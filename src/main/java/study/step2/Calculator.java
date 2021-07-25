package study.step2;

import study.step2.Intf.CalculatorIntf;

import java.util.Arrays;
import java.util.List;

public class Calculator implements CalculatorIntf {


    private List operator;
    private String[] calcStrArry;


    public Calculator() {
        this.operator = Arrays.asList("+", "-", "*", "/");
    }

    @Override
    public int calc(String calcStr) {

        int result = 0;
        Calc calc = new Calc();

        calcStrArry = calcStr.split(" ");

        for (int idx = 0; idx < calcStrArry.length; idx++) {

            String idxStr = calcStrArry[idx];
            if (operator.contains(idxStr)) {
                if (result == 0) {
                    result = Integer.parseInt(calcStrArry[idx - 1]);
                }

                result = calc.calc(idxStr, result, Integer.parseInt(calcStrArry[idx + 1]));
            }
        }

        return result;
    }
}
