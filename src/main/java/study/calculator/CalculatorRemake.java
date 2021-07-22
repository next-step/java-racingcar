package study.calculator;

import java.util.*;
import java.util.stream.Collectors;

import static study.calculator.Common.*;

public class CalculatorRemake {

    public static int getResult(List<String> valueAndOperations) {

        int accumulateNumber = Integer.parseInt(valueAndOperations.get(0));

        for(int j = 1; j< valueAndOperations.size(); j+=2){
            accumulateNumber = Operation.chooseOperation(valueAndOperations.get(j)).calculateNumbers(accumulateNumber,Integer.parseInt(valueAndOperations.get(j+1)));
        }

        return accumulateNumber;
    }

    public static void start() {
        System.out.println(" 수식을 입력하세요 ex) 2 + 3");

        String[] words = inputValue().split(" ");

        System.out.println("result = " + getResult(Arrays.stream(words).collect(Collectors.toList())));

    }

}
