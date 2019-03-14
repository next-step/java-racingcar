package calculator;

import util.StringUtils;

import java.util.*;

import static java.lang.System.exit;

public class StringCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();

        if( StringUtils.isNullOrEmpty(inputLine) ) {
            System.out.println("수식을 입력하지 않았습니다.");
            exit(0);
        }

        System.out.println(calculate(inputLine));
    }

    static int calculate(String inputLine) {
        String [] inputs = inputLine.split(" ");
        int length = inputs.length;

        Integer result = Integer.valueOf(inputs[0]);

        for( int i = 1; i < length; i+=2 ) {
            String operator = inputs[i];
            Integer operand = Integer.parseInt(inputs[i+1]);
            result = Invoker.getOperation(operator).calculate( result, operand );
        }

        return result;
    }


}