package venky.project.dsl.antlr4;

import com.google.common.io.CharStreams;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitnessVisitorImpl extends FitnessBaseVisitor<String> {
  @Override
  public String visitCommand(FitnessParser.CommandContext ctx) {

    if (ctx.DISTANCE() != null) {
      // get the distance, time and unit values
      String distance = ctx.NUMBER(0).toString();
      String time = ctx.NUMBER(1).toString();

      String speed = String.valueOf(Integer.valueOf(distance) / Integer.valueOf(time));
      String calories = String.valueOf(Integer.valueOf(distance) * 70);

      JsonObject object = new JsonObject();
      object.addProperty("distance", distance + ctx.DISTANCE().toString());
      object.addProperty("speed", speed + ctx.DISTANCE().toString() + " per " + ctx.TIME().toString());
      object.addProperty("calories", calories);

      return object.toString();
    } else {
      try {

        // TODO read it from a database instead of flat-file
        String nutritionInfoStream = CharStreams.toString(new InputStreamReader(getClass().getClassLoader()
            .getResourceAsStream("nutritioninfo.json"), "utf-8"));

        JsonObject nutritionInfo = new JsonParser().parse(nutritionInfoStream).getAsJsonObject();
        JsonArray information = nutritionInfo.get("nutrition_info").getAsJsonArray();

        for (JsonElement jsonElement : information) {
          if (jsonElement.getAsJsonObject().get("name").getAsString().equals(ctx.FRUIT().toString())) {
            return jsonElement.toString();
          }
        }

        // If not found, throw a NotFoundException
        throw new NotFoundException("No nutrition information found for the food: " + ctx.FRUIT().toString());
      } catch (IOException e) {
        throw new RuntimeException("Cannot read the database to lookup nutrition information");
      }
    }
  }
}
