package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class calculator {
    // For Console Test
    /*static final boolean flag = true;*/
    static int cal1; // 피연산자1
    static int cal2; // 피연산자2
    static String calMethod; // 사칙연산 종류

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?"); // 숫자 체크 정규식

    private static Queue<String> calStack = new LinkedList<String>(); // 계산 큐 구현

    /**
     * 최초 값 초기화 메소드
     */
    static void init() {
        cal1 = Integer.MIN_VALUE;
        cal2 = Integer.MIN_VALUE;
        calMethod = null;
    }

//    Console Test
//    public static void main() throws Exception {
//        Scanner sc = new Scanner(System.in);
//
//        while (flag) {
//            String formula;
//            System.out.print("계산할 식을 입력하세요 : ");
//            formula = sc.nextLine();
//            // chk
//            System.out.println(formula);
//            int result = process(formula);
//            System.out.println("계산 결과 : " + result + " ");
//        }
//    }

    /**
     * 실제 계산 프로세스
     * @param formula 사칙연산이 들어간 최초 입력 값
     * @return 계산 결과
     * @throws Exception
     */
    static int process(String formula) throws Exception {
        // 초기화
        init();
        // 최초 입력값 체크
        if (formula.equals("") || formula.equals(" ") || formula.equals(null)) {
            throw new IllegalArgumentException("입력 값 공백 또는 빈 문자 에러");
        }
        // 큐에 데이터 넣기
        calStack.addAll(List.of(formula.split(" ")));
        // 큐의 데이터가 없을 때 까지 반복
        while (!calStack.isEmpty()) {
            // 숫자 체크
            if (pattern.matcher(calStack.peek()).matches()) {
                // 체크하여 어떤 피연산자로 넣을지 결정
                judgeInteger(Integer.parseInt(calStack.poll()));
            } else {
                // 사칙연산 맞는지 체크
                judgeMethod(calStack.poll());
            }
            // 계산 가능 조건이 되는 경우, 계산하여 다시 저장
            if (calMethod != null && cal2 != Integer.MIN_VALUE) {
                // 실제 계산
                doCal(cal1, cal2);
                // 계산 후, 사용 값 초기화. 단, 연산자 1은 계산 결과를 담고 있으므로 제외.
                cal2 = Integer.MIN_VALUE;
                calMethod = null;
            }
        }
        // 끝난 후, 결과값 리턴.
        return cal1;
    }

    /**
     * a,b를 현재 사칙연산에 맞게 계산 후, 저장한다.
     * @param a
     * @param b
     */
    static void doCal(int a, int b) {
        switch (calMethod) {
            case "+":
                cal1 = plus(a, b);
                break;
            case "-":
                cal1 = minus(a, b);
                break;
            case "*":
                cal1 = multiple(a, b);
                break;
            case "/":
                cal1 = devide(a, b);
                break;
            default:
                break;
        }
    }

    /**
     * 넘어온 값을 조건에 맞게 연산자에 저장한다.
     * @param x
     * @throws Exception
     */
    static void judgeInteger(int x) throws Exception {
        if (cal1 == Integer.MIN_VALUE) {
            cal1 = x;
        } else if (cal2 == Integer.MIN_VALUE) {
            cal2 = x;
        } else {
            // 로직 상 발생하면 안되는 케이스 이지만, 예외 처리 함.
            throw new Exception("연산자오류");
        }
    }

    /**
     * 사칙연산 판단 로직, 사칙연산에 해당하지 않는 값인 경우 IllegalArgumentException 오류를 리턴한다.
     * @param method
     */
    static void judgeMethod(String method) {
        if (method.equals("+") || method.equals("-") || method.equals("*") || method.equals("/")) {
            calMethod = method;
        } else {
            throw new IllegalArgumentException("사칙연산 입력값 오류");
        }
    }

    /**
     * 덧셈 메소드
     * @param a
     * @param b
     * @return
     */
    static int plus(int a, int b) {
        return a + b;
    }

    /**
     * 빼기 메소드
     * @param a
     * @param b
     * @return
     */
    static int minus(int a, int b) {
        return a - b;
    }

    /**
     * 곱셈 메소드
     * @param a
     * @param b
     * @return
     */
    static int multiple(int a, int b) {
        return a * b;
    }

    /**
     * 나눗셈 메소드
     * @param a
     * @param b
     * @return
     */
    static int devide(int a, int b) {
        return a / b;
    }

    @DisplayName("test of plus method")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 1", "10 + 23", "102 + 295 + 13"})
    int plus(String str) throws Exception {
        return process(str);
    }

    @DisplayName("test of minus method")
    @ParameterizedTest
    @ValueSource(strings = {"1 - 1", "15 - 4", "290 - 44 - 109"})
    int minus(String str) throws Exception {
        return process(str);
    }

    @DisplayName("test of multiple method")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 1", "238 * 0", "8 * 8 * 2"})
    int multiple(String str) throws Exception {
        return process(str);
    }

    @DisplayName("test of devide method")
    @ParameterizedTest
    @ValueSource(strings = {"1 / 1", "99 / 11", "384 / 2 / 192"})
    int devide(String str) throws Exception {
        return process(str);
    }

    @DisplayName("test of null, white space input case")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void IllegalArgumentException1(String str) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                process(str);
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("test of Not four arithmetic operations case")
    @ParameterizedTest
    @ValueSource(strings = {"1 = 1", "2 ) 2"})
    void IllegalArgumentException2(String str) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                process(str);
            }).isInstanceOf(IllegalArgumentException.class);
    }

}
