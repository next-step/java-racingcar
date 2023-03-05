package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {

    static int cal1; // 피연산자1
    static int cal2; // 피연산자2
    static String calMethod; // 사칙연산 종류

    private static String methodExp = "/\\*|\\+|\\-|\\//g"; // 사칙연산 정규식 패턴
    private static String numberExp = "[0-9]+"; // 숫자 정규식 패턴

    private static Queue<String> calStack = new LinkedList<String>(); // 계산 큐 구현

    static void init() {
        cal1 = Integer.MIN_VALUE;
        cal2 = Integer.MIN_VALUE;
        calMethod = "";
    }

    /**
     * 실제 계산 프로세스
     *
     * @param input 사칙연산이 들어간 최초 입력 값
     * @return 계산 결과
     * @throws Exception
     */
    int calculate(String input) throws Exception {
        // 초기화
        init();
        // 최초 입력값 체크
        inputValidateChk(input);
        // 큐에 데이터 넣기
        calStack.addAll(List.of(input.split(" ")));
        // 큐의 데이터가 없을 때 까지 반복
        while (!calStack.isEmpty()) {
            // 스택 꺼낸 값 체크
            judge(calStack.poll());
            // 계산 가능 조건이 되는 경우, 계산하여 다시 저장
            if (calMethod != null && cal2 != Integer.MIN_VALUE) {
                // 실제 계산
                cal1 = doCal(cal1, cal2);
                // 계산 후, 사용 값 초기화. 단, 연산자 1은 계산 결과를 담고 있으므로 제외.
                cal2 = Integer.MIN_VALUE;
                calMethod = null;
            }
        }
        // 끝난 후, 결과값 리턴.
        return cal1;
    }

    /**
     * 최초 입력값 체크
     *
     * @param input 입력값
     */
    static void inputValidateChk(String input) {
        if (input.equals("") || input.equals(" ") || input == null || input.isEmpty()
            || input.isBlank()) {
            throw new IllegalArgumentException("입력 값 공백 또는 빈 문자 에러");
        }
    }

    /**
     * 스택에서 꺼낸 값을 숫자/연산자 판단
     *
     * @param pollValue 스택에서 꺼낸 값
     * @throws Exception
     */
    static void judge(String pollValue) throws Exception {
        System.out.println("pollValue : " + pollValue);
        // 숫자 체크
        if (pollValue.matches(numberExp)) {
            System.out.println("넘버");
            // 체크하여 어떤 피연산자로 넣을지 결정
            judgeInteger(Integer.parseInt(pollValue));
            return;
        }
        // 사칙연산 맞는지 체크
        operationValidChk(pollValue);
    }

    /**
     * a,b를 현재 사칙연산에 맞게 계산 후, 저장한다.
     *
     * @param a
     * @param b
     */
    static int doCal(int a, int b) {
        if (calMethod.equals("+")) {
            return plus(a, b);
        }
        if (calMethod.equals("-")) {
            return minus(a, b);
        }
        if (calMethod.equals("*")) {
            return multiple(a, b);
        }
        if (calMethod.equals("/")) {
            return devide(a, b);
        }
        return a;
    }

    /**
     * 넘어온 값을 조건에 맞게 연산자에 저장한다.
     *
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
     *
     * @param operation
     */
    static void operationValidChk(String operation) throws IllegalArgumentException {
        System.out.print(operation);
        if (!(operation.equals("+") || operation.equals("-") || operation.equals("*")
            || operation.equals(
            "/"))) {
            throw new IllegalArgumentException("사칙연산 입력값 오류");
        }
        calMethod = operation;
    }

    /**
     * 덧셈 메소드
     *
     * @param a
     * @param b
     * @return
     */
    static int plus(int a, int b) {
        return a + b;
    }

    /**
     * 빼기 메소드
     *
     * @param a
     * @param b
     * @return
     */
    static int minus(int a, int b) {
        return a - b;
    }

    /**
     * 곱셈 메소드
     *
     * @param a
     * @param b
     * @return
     */
    static int multiple(int a, int b) {
        return a * b;
    }

    /**
     * 나눗셈 메소드
     *
     * @param a
     * @param b
     * @return
     */
    static int devide(int a, int b) {
        return a / b;
    }

}
