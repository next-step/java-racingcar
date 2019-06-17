<<<<<<< HEAD


import java.util.Scanner;

import static com.sun.tools.internal.xjc.reader.Ring.add;
=======
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/*
문자열 계산기 요구사항
1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
2. 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
3. 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
4. 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
5. 함수별 JUnit 테스트 통과
 */

/*
진행사항
1. 단일 사칙연산 기능 구현 (완료)
2. 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw (완료)
3. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw (완료)
4. 사칙 연산을 모두 포함하는 기능 구현 (완료)
 */
>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee

public class StringCalculator {

    // 각 연산의 결과값을 저장하는 변수
    public static int addResult, subtractResult, multiplyResult, divideResult;
<<<<<<< HEAD

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("사칙연산을 위한 문자열을 입력해하세요");
=======
    public static boolean isBlankStringOrNull;

    public static void main(String[] args) {
        String[] array_input;
        String result;

        // 사용자 입력을 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        System.out.println("사칙연산을 위한 문자열을 입력하세요");
>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee

        //사용자에게 문자열 입력
        String input = sc.nextLine();

<<<<<<< HEAD
        // 각 연산 실행
//        Add(input);
//        Subtract(input);
//        Multiply(input);
        Divide(input);

        System.out.println("더하기 결과는 " + addResult);
        System.out.println("빼기 결과는 " + subtractResult);
        System.out.println("곱하기 결과는 " + multiplyResult);
        System.out.println("나누기 결과는 " + divideResult);
=======
        // 입력값이 빈 공백 문자 or null 체크
        checkNullorBlankString(input);

        // 입력값이 사칙연산 부호가 맞는지 체크
        array_input = checkOperationSign(input);

        // 사칙연산 계산기 실행
        result = runCalculator(array_input);

        System.out.println("사칙연산 수행이 완료되었습니다. 결과값은 " + result + "입니다.");

>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee
    }


    /*
    add() 함수
    */
<<<<<<< HEAD

    static void Add(String input){
        int plusIndex = input.indexOf("+");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        addResult = num1 +num2;
=======
    static String add(String input) {
        int signIndex = input.indexOf("+");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        return String.valueOf(num1 + num2);
>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee

    }

    /*
    Subtract() 함수
    */
<<<<<<< HEAD
    static void Subtract(String input){
        int plusIndex = input.indexOf("-");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        subtractResult = num1 -num2;
=======
    static String subtract(String input) {
        int signIndex = input.indexOf("-");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        return String.valueOf(num1 - num2);
>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee

    }

    /*
    Multiply() 함수
    */
<<<<<<< HEAD
    static void Multiply(String input){
        int plusIndex = input.indexOf("*");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        multiplyResult = num1 * num2;
=======
    static String multiply(String input) {
        int signIndex = input.indexOf("*");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        return String.valueOf(num1 * num2);
>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee

    }

    /*
    Divide() 함수
    */
<<<<<<< HEAD
    static void Divide(String input){
        int plusIndex = input.indexOf("/");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        divideResult = num1 / num2;
=======
    static String divide(String input) {
        int signIndex = input.indexOf("/");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
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

            // 사칙연산을 위해서 문자열 배열의 값을 순차적으로 문자열로 합침.
            result += array_input[i];

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
>>>>>>> 7f296e93c310e85dd5b1a72a8258310a999e5cee
    }

}
