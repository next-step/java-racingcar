package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private Queue<Integer> numbers;

    private Queue<String> operators;

    private int  sumNumber;

    public StringCalculator() {
        numbers =  new LinkedList<>();
        operators =  new LinkedList<>();
        sumNumber = 0;
    }

    public  int add(String text){
        if(text.isEmpty()){
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
        }


        int number = Integer.parseInt(text);

        return 0;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a -b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a /  b;
    }






}
