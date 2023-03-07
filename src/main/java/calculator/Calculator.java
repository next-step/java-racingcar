package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {

    private static String EXP_NUMBER = "[0-9]+"; // 숫자 정규식 패턴

    private static Queue<String> calStack = new LinkedList<String>(); // 계산 큐 구현

    /**
     * 실제 계산 프로세스
     *
     * @param input 사칙연산이 들어간 최초 입력 값
     * @return 계산 결과
     * @throws Exception
     */
    int calculate(String input) throws Exception {
        int cal1 = 0;
        int cal2 = 0;
        String calMethod = "";
        // 최초 입력값 체크
        inputValidateChk(input);
        // 큐에 데이터 넣기
        calStack.addAll(List.of(input.split(" ")));
        // 계산 초기값 세팅
        if (numberCheck(calStack.peek())) {
            cal1 = Integer.parseInt(calStack.poll());
        }
        // 큐의 데이터가 없을 때 까지 반복
        while (!calStack.isEmpty()) {
            // 스택 꺼낸 값 체크
            if (methodCheck(calStack.peek())) {
                calMethod = calStack.poll();
            }
            if (numberCheck(calStack.peek())) {
                cal2 = Integer.parseInt(calStack.poll());
            }
            cal1 = doCal(cal1, cal2, calMethod);
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
        if (input.isBlank() || input.equals(null)) {
            throw new IllegalArgumentException("입력 값 공백 또는 빈 문자 에러");
        }
    }

    /**
     * 큐에서 꺼내온 값이 사칙연산이 맞는지 체크.
     *
     * @param pollValue 꺼내온 값
     * @return
     */
    static boolean methodCheck(String pollValue) {
        System.out.println("pollValue : " + pollValue);
        // 숫자인지 먼저 체크 해서, 숫자면 false 리턴.
        if (pollValue.matches(EXP_NUMBER)) {
            return false;
        }
        // 숫자가 아니라 문자인 경우, 사칙연산 체크.
        if (operationValidChk(pollValue)) {
            return true;
        }
        return false;
    }

    /**
     * 큐에서 꺼내온 값이 숫자 값인지 체크
     *
     * @param pollValue 꺼내온 값
     * @return
     */
    static boolean numberCheck(String pollValue) {
        if (pollValue.matches(EXP_NUMBER)) {
            return true;
        }
        return false;
    }

    /**
     * a,b를 현재 사칙연산에 맞게 계산 후, 저장한다.
     *
     * @param a
     * @param b
     */
    static int doCal(int a, int b, String calMethod) {
        int result = 0;
        if (calMethod.equals("+")) {
            result = plus(a, b);
        }
        if (calMethod.equals("-")) {
            result = minus(a, b);
        }
        if (calMethod.equals("*")) {
            result = multiple(a, b);
        }
        if (calMethod.equals("/")) {
            result = devide(a, b);
        }
        return result;
    }

    /**
     * 사칙연산 판단 로직, 사칙연산에 해당하지 않는 값인 경우 IllegalArgumentException 오류를 리턴한다.
     *
     * @param pollValue
     */
    static boolean operationValidChk(String pollValue) throws IllegalArgumentException {
        if (!(pollValue.equals("+") || pollValue.equals("-") || pollValue.equals("*")
            || pollValue.equals(
            "/"))) {
            throw new IllegalArgumentException("사칙연산 입력값 오류");
        }
        return true;
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
