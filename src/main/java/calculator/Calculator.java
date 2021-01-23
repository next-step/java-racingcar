package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    private ArrayList<String> operators;
    private ArrayList<String> operands;

    public double getAnswer(String formula) {
        setRequirements(formula);
        Validator.validateFormula(operands, operators);
        ArrayList<Double> doubleOperands = Utility.stringToDouble(operands);
        return calculateFormula(operators, doubleOperands);
    }

    /**
     * Split and Set operators and operands from math equation.
     * @param formula String of math equations
     * @return result Double, calculated result
     */
    private void setRequirements(String formula) {
        String eq = formula.replaceAll(" ", "");
        operators = Utility.splitFormula(eq, "[0-9]+");
        operands = Utility.splitFormula(eq, "[-+*/()]");
    }


    private double calculateFormula(ArrayList<String> operators, ArrayList<Double> operands) {
        double result = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            result = Arithmetic.calculate(operators.get(i-1), result, operands.get(i));
        }
        return result;
    }

}