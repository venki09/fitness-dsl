package venky.project.dsl.antlr4;

public class FitnessVisitorImpl extends FitnessBaseVisitor<String> {

  @Override
  public String visitNutritioncommand(FitnessParser.NutritioncommandContext ctx) {
    System.out.println("olaaa");
    return super.visitNutritioncommand(ctx);
  }

  @Override
  public String visitExercisecommand(FitnessParser.ExercisecommandContext ctx) {
    return super.visitExercisecommand(ctx);
  }
}
