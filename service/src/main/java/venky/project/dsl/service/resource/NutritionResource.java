package venky.project.dsl.service.resource;

import com.cerner.beadledom.jaxrs.JaxRsParamConditions;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.cerner.beadledom.jaxrs.GenericResponse;
import com.cerner.beadledom.jaxrs.GenericResponses;
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

@Api(value = "/nutrition_info", description = "Retrieve nutrition information of a food.")
@Path("/nutrition_info")
public class NutritionResource {

  @ApiOperation(
      value = "Retrieves hello world data.",
      response = String.class)
  @ApiResponse(code = 200, message = "Success")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public GenericResponse<String> getNutritionInfo(@QueryParam("food") String food) {
    JaxRsParamConditions.checkParam(food != null, "Food cannot be null");

    String expression = "How many calories in " + food;

    CharStream stream = CharStreams.fromString(expression);
    FitnessLexer lexer = new FitnessLexer(stream);
    CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    FitnessParser parser = new FitnessParser(commonTokenStream);
    parser.setErrorHandler(new BailErrorStrategy());
    ParseTree tree = parser.command();
    FitnessVisitorImpl visitor = new FitnessVisitorImpl();

    return GenericResponses
        .ok(visitor.visit(tree))
        .build();
  }
}
