package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    static int calculator(String str) {

        // 문자열에서 숫자를 찾는다. 다음 숫자가 나오면
        // 이전의 숫자와 다음 숫자르 더한다..
        // 기호와 숫자를 분리해야함.
        // 숫자를 2개씩 저장하는 배열이 잇으면 좋을 것 같음
        // 기호를 저장하는 변수가 필요함

        // 홀수의 숫자만 저장하도록해서 숫자만 가지고 있는 리스트를 만든다
        // 짝수만 저장해서 기호만 가지고 있는 리스트를 만든다.
        // 숫자 2개와 기호 1개를 받아서 연산하는 로직을 만든다.

        // 띄우쓰기를 우선 제거
        String trim_str = str.trim();

        int result = 0;

        // 홀수는 숫자 짝수는 기호

        // 피연산자를 저장해주는 리스트
        List<Integer> operand_list = new ArrayList<>();
        // 연산자를 저장해주는 리스트
        List<String> operator_list = new ArrayList<>();

        String [] split_trim_str = trim_str.split("");

        for (int i = 1; i < trim_str.length() + 1; i++) {

            // 기호인 경우
            if (i % 3 == 0 || i == 1) {
                operand_list.add(Integer.valueOf(split_trim_str[i - 1]));
            }

            if (i % 2 == 0 ) {
                operator_list.add(split_trim_str[i - 1]);
            }

            //2개의 오퍼랜드와 한개의 오퍼레이터를 넘긴다.

            if (operand_list.size() == 2) {
                int value = calculator(operand_list.get(0), operand_list.get(1), operator_list.get(0));
                result += value;
                operand_list.clear();
                operator_list.clear();
            }
        }

        return result;
    }

    public static int calculator(int a, int b, String oprator) {

        int result = 0;
        if (oprator.equals("-")) {
            result = a - b;
        }

        if (oprator.equals("+")) {
            result = a + b;
        }

        if (oprator.equals("*")) {
           result = a * b;
        }

        if (oprator.equals("/")) {

            result = b == 0? 0 : a/b;
        }

        return result;
    }
}
