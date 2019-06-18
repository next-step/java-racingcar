import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) {
        String[] array_input;
        String result;

        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성

        System.out.println("사칙연산을 위한 문자열을 입력하세요");

        String input = sc.nextLine(); //사용자에게 문자열 입력

        checkNullorBlankString(input); // 입력값이 빈 공백 문자 or null 체크

        array_input = checkOperationSign(input); // 입력값이 사칙연산 부호가 맞는지 체크

        result = runCalculator(array_input); // 사칙연산 계산기 실행

        System.out.println("사칙연산 수행이 완료되었습니다. 결과값은 " + result + "입니다.");
    }

    /*
    뎃셈연산 함수
    */
    static String add(String input) {
        String[] array_input = input.split("\\+");
        int num1 = Integer.parseInt(array_input[0]);
        int num2 = Integer.parseInt(array_input[1]);
        return String.valueOf(num1 + num2);
    }

    /*
    뺄셈연산 함수
    */
    static String subtract(String input) {
        String[] array_input = input.split("-");
        int num1 = Integer.parseInt(array_input[0]);
        int num2 = Integer.parseInt(array_input[1]);
        return String.valueOf(num1 - num2);

    }

    /*
    곱셈연산 함수
    */
    static String multiply(String input) {
        String[] array_input = input.split("\\*");
        int num1 = Integer.parseInt(array_input[0]);
        int num2 = Integer.parseInt(array_input[1]);
        return String.valueOf(num1 * num2);

    }

    /*
    나눗셈 연산 함수
    */
    static String divide(String input) {
        String[] array_input = input.split("/");
        int num1 = Integer.parseInt(array_input[0]);
        int num2 = Integer.parseInt(array_input[1]);
        return String.valueOf(num1 / num2);
    }

    /*
    입력값이 빈 공백 문자 or null 값 여부 체크 함수
    */
    static void checkNullorBlankString(String input) {
        if (StringUtils.isBlank(input))
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 입력하신 문자열이 null 이거나 빈 공백 문자입니다.");
    }

    /*
    입력값이 사칙연산 부호 여부 체크 함수
    */
    static String[] checkOperationSign(String input) {
        String[] array_input;

        // 사칙연산 부호 확인을 위해서 split() 함수를 이용하여 공백문자 기준으로 문자열(사용자 입력값)을 문자열 배열로 나눔.
        array_input = input.split(" ");

        for (int i = 0; i < array_input.length; ++i) {
            // 배열의 인덱스의 값이 홀수 일때 사친연산 부호가 입력이 되므로 해당 조건으로 체크
            if (i % 2 == 1) {
                switch (array_input[i]) {
                    case "+":
                        break;

                    case "-":
                        break;

                    case "*":
                        break;

                    case "/":
                        break;
                    // 사칙연산 부호가 아닌 경우에 Exception 발생.
                    default:
                        throw new IllegalArgumentException("입력값이 잘못되었습니다. 사칙연산이 아닌 기호가 입력되었습니다.");
                }
            }
        }
        return array_input;
    }

    static String runCalculator(String array_input[]) {
        String result = "";

        for (int i = 0; i < array_input.length; ++i) {
            result += array_input[i]; // 사칙연산을 위해서 문자열 배열의 값을 순차적으로 문자열로 합침.

            // 정상적으로 입력이 되었을 경우, 첫번째 연산의 실행 조건이 배열의 인덱스의 값이 2일 경우(입력값이 세자리가 되는 경우)이며
            // 인덱스의 값이 짝수 경우일때, 이전 입력값(i-1)의 사칙연산 부호의 값을 체크하여 계산을 실행.
            // 계산의 결과값은 변수 result에 넣어두어, 다음 계산에 다시 활용.
            if (i > 0 && i % 2 == 0) {
                switch (array_input[i - 1]) {
                    case "+":
                        result = add(result);
                        break;

                    case "-":
                        result = subtract(result);
                        break;

                    case "*":
                        result = multiply(result);
                        break;

                    case "/":
                        result = divide(result);
                        break;

                    default:
                        break;

                }
            }
        }
        return result;
    }
}



