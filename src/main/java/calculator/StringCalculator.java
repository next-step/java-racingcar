package calculator;

import java.util.Scanner;

public class StringCalculator {

    public String splitUserInput(String input) {
        
        String test = "";

        for (String data : input.split(" ")) {
            test += data;
        }

        return test;
    }

    // 문자열을 분석해서 숫자로 변경할 수 있는지 먼저 판단

    //add

    //minus

    //multi

    //divide

    // 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw

    // 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
}
