package step1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        final FormulaParser formulaParser = FormulaParserFactory.sequentialInteger();
        final Formula formula = formulaParser.parse(input.nextLine());
        final FormulaNodeValue value = formula.evaluate();

        System.out.println(value.asInt());
    }
}
