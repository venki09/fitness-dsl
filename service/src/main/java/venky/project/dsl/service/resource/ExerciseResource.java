package venky.project.dsl.service.resource;

import com.cerner.beadledom.jaxrs.GenericResponse;
import com.cerner.beadledom.jaxrs.GenericResponses;
import com.cerner.beadledom.jaxrs.JaxRsParamConditions;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import venky.project.dsl.antlr4.FitnessLexer;
import venky.project.dsl.antlr4.FitnessParser;
import venky.project.dsl.antlr4.FitnessVisitorImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Api(value = "/exercise_info", description = "Retrieve exercise information.")
@Path("/exercise_info")
public class ExerciseResource {

  @ApiOperation(
      value = "Retrieves hello world data.",
      response = String.class)
  @ApiResponse(code = 200, message = "Success")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public GenericResponse<String> getExerciseInfo(@QueryParam("exercise") String exercise,
                                                 @QueryParam("distance") String distance,
                                                 @QueryParam("unit") String unit,
                                                 @QueryParam("time") String time) {
    JaxRsParamConditions.checkParam(exercise != null, "Exercise cannot be null");
    JaxRsParamConditions.checkParam(distance != null, "Distance cannot be null");
    JaxRsParamConditions.checkParam(unit != null, "Unit cannot be null");
    JaxRsParamConditions.checkParam(time != null, "Time cannot be null");

    String expression = "I " + exercise + " " + distance + " " + unit + " in " + time + " hour";

    CharStream stream = CharStreams.fromString(expression);
    FitnessLexer lexer = new FitnessLexer(stream);
    CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    FitnessParser parser = new FitnessParser(commonTokenStream);
    parser.setErrorHandler(new BailErrorStrategy());
    ParseTree tree = parser.command();
    FitnessVisitorImpl visitor = new FitnessVisitorImpl();
    String ss = visitor.visit(tree);

    if (ss.isEmpty()) {
      return GenericResponses.ok("NOT_FOUND").build();
    }

    return GenericResponses
        .ok(ss)
        .build();
  }
}
