package venky.project.dsl;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import venky.project.dsl.antlr4.FitnessLexer;
import venky.project.dsl.antlr4.FitnessParser;
import venky.project.dsl.antlr4.FitnessVisitorImpl;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String expression = sc.nextLine();

    CharStream stream = CharStreams.fromString(expression);
    FitnessLexer lexer = new FitnessLexer(stream);
    CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    FitnessParser parser = new FitnessParser(commonTokenStream);
    parser.setErrorHandler(new BailErrorStrategy());
    ParseTree tree = parser.command();
    FitnessVisitorImpl visitor = new FitnessVisitorImpl();
    String ss = visitor.visit(tree);

    System.out.println(ss);
    sc.close();
  }
}
