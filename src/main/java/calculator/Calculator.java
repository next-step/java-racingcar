package calculator;

public class Calculator {

    public double calculator(String input) {
        final String[] actual = input.split(" ");

        double result = 0;      // 결과값
        int arg;                // 인수
        String opr = null;      // 연샨자
        boolean chk = false;    // 첫번째 row체크

        for (String ac : actual) {
            // 첫row인 경우
            if (!chk) {
                result = Double.parseDouble(ac);
                chk = true;
                continue;
            }

            // 연산자 인지?
            if (ac.equals("+") || ac.equals("-") || ac.equals("*") || ac.equals("/") ) {
                // 연산자 저장 후 continue
                opr = ac;
            } else {
                // 숫자인 경우 계산
                arg = Integer.parseInt(ac);
                result = calc(result, opr, arg);
            }
        }
        return result;
    }

    private double calc(Double result, String opr, int arg) {
        // 사칙연산 계산
        if (opr.equals("+")) {
            return result + arg;
        }
        if (opr.equals("-")) {
            return result - arg;
        }
        if (opr.equals("*")) {
            return result * arg;
        }
        if (opr.equals("/")) {
            zeroChk(arg);
            return result / arg;
        }
        throw new IllegalArgumentException("연산자 확인 필요.");
    }

    private void zeroChk(int arg) {
        if (arg == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없음.");
        }
    }

}
