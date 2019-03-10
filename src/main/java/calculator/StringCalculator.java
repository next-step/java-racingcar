package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    static int calculator(String inputString)  {
        // 문자열에서 숫자를 찾는다. 다음 숫자가 나오면
        // 이전의 숫자와 다음 숫자르 더한다..
        // 기호와 숫자를 분리해야함.
        // 숫자를 2개씩 저장하는 배열이 잇으면 좋을 것 같음
        // 기호를 저장하는 변수가 필요함

        // 홀수의 숫자만 저장하도록해서 숫자만 가지고 있는 리스트를 만든다
        // 짝수만 저장해서 기호만 가지고 있는 리스트를 만든다.
        // 숫자 2개와 기호 1개를 받아서 연산하는 로직을 만든다.
        // 재귀로 하면 좋을 것 같음

        // 띄우쓰기를 우선 제거
        String trimString = inputString.trim();

        int result = 0;

        // 홀수는 숫자 짝수는 기호

        // 피연산자를 저장해주는 리스트
        List<Integer> operandList = new ArrayList<>();
        // 연산자를 저장해주는 리스트
        List<String> operatorList = new ArrayList<>();
        // 임시로 저장하기 위한 StringBuffer
        StringBuilder tempString = new StringBuilder();

        String [] splitTrimString = trimString.split("");

        for (int i = 0; i < splitTrimString.length; i++) {

            // 문자열을 하나씩 임시 리스트에 저장하다가 기호 형태를 만나면
            // 이전에 저장해왔던 임시 리스트의 값을 operand 리스트에 저장하고
            // 기호 형태를 operator 리스트에 저장한 후 다음 기호 형태가 나올 때까지 다시 저장한다.
            // 그리고 연산 후 그 연산한 값을 그 다음 기호가 나올 때 까지 반복 한다.

            tempString.append(splitTrimString[i]);

            // 연산자를 만났을 경우
            if(splitTrimString[i].equals("+") || splitTrimString[i].equals("*") ||
                    splitTrimString[i].equals("-") || splitTrimString[i].equals("/")) {
                String temp = tempString.toString();
                temp = temp.substring(0, tempString.length() - 1);
                operandList.add(Integer.parseInt(temp));
                operatorList.add(splitTrimString[i]);
                tempString.setLength(0);
            }

            // 마지막 문자열의 경우 연산자 추가 없이 값만 추가해준다.
            if(i == splitTrimString.length - 1) {
                operandList.add(Integer.parseInt(String.valueOf(tempString)));
            }

            //2개의 오퍼랜드와 한개의 오퍼레이터를 넘긴다.
            if (operandList.size() == 2) {
                int value = calculator(operandList.get(0), operandList.get(1), operatorList.get(0));
                result = value;
                operandList.clear();
                operatorList.remove(0);
                operandList.add(value);
            }
        }

        return result;
    }

    public static int calculator(int a, int b, String operator) {

        int result = 0;
        if (operator.equals("-")) {
            result = a - b;
        }

        if (operator.equals("+")) {
            result = a + b;
        }

        if (operator.equals("*")) {
           result = a * b;
        }

        if (operator.equals("/")) {
            // 분모가 0인 경우 에러처리
            if(b == 0) {
                throw new IllegalArgumentException();
            }

            result = b == 0? 0 : a / b;
        }

        return result;
    }

    public static String inputConsole()  {
        System.out.println("계산하고자하는 문자열을 입력하세요");
        System.out.print(" : ");

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        if(value.length() < 1) {
            throw new IllegalArgumentException();
        }

        return value;
    }
}
