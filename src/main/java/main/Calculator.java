package main;

import util.Operator;

import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern pattern = Pattern.compile("^[0-9]+");
    public double calRes =0;
    public Calculator() {
    }
    public Double getcalRes() {
        return this.calRes;
    }
    public double calculate(String input) {
        String[] inputArray = input.split(" ");
        double tempResult= Double.parseDouble(inputArray[0]);
        Operator operator=new Operator();
        for (int i = 1; i < inputArray.length; i++) {
            if (pattern.matcher(inputArray[i]).matches()) {
                tempResult = Operator.operateArithmetic(tempResult, inputArray[i], Integer.parseInt(inputArray[i + 1]));
            }
        }
        Double result=tempResult;
        return result;
    }
}
