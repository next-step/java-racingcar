package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    /**
     * Split string formula by using regex.
     * @param formula String of math equations
     * @param regex String of regular expression.
     * @return equation, Array of String.
     */
    public static ArrayList<String> splitFormula(String formula, String regex) {
        ArrayList<String> equation = new ArrayList<>(Arrays.asList(formula.split(regex)));
        equation.remove("");   // 리스트안에 있는 빈 공백을 지운다.
        return equation;
    }

    public static ArrayList<Double> stringToDouble(ArrayList<String> array) {
        ArrayList<Double> result = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            result.add(i, Double.parseDouble(array.get(i)));
        }
        return result;
    }

}