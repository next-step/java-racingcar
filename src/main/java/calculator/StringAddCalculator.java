package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public StringAddCalculator(){}

    public int add(String input) {
        return sumAllNumbers(
                convertStringToInt(
                        parseStringToArray(
                                isNotNullOrEmpty(input))));
    }

    private String isNotNullOrEmpty(String input) {
        if (input == null) return "0";
        if (input.isEmpty()) return "0";
        return input;
    }

    private String[] parseStringToArray(String input) {
        return input.split(",|:");
    }

    private List<Integer> convertStringToInt(String[] texts) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(String text : texts){
            int number = Integer.parseInt(text);
            numbers.add(number);
        }
        return numbers;
    }

    public int sumAllNumbers(List<Integer> numbers){
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
