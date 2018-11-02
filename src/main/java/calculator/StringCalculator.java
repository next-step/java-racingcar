package calculator;

public class StringCalculator {

    public static int calculate(String text) {
        String[] values = text.split(" ");

        // 초깃값은 values의 첫번째 값을 기준점으로 함
        int sum = Integer.valueOf(values[0]);

        for (int idx = 1; idx < (values.length + 1) / 2; idx++) {
            // 연산자 추출
            String operator = values[idx * 2 - 1];

            // 우변 값 추출
            int rightHand = Integer.valueOf(values[idx * 2]);

            // 연산 수행
            sum = operate(operator, sum, rightHand);
        }

        // 결과 반환
        return sum;
    }

    private static int operate(String operator, int leftHand, int rightHand) {
        if ("+".equals(operator)) {
            return leftHand + rightHand;
        }

        if ("-".equals(operator)) {
            return leftHand - rightHand;
        }

        if ("/".equals(operator)) {
            return leftHand / rightHand;
        }

        if ("*".equals(operator)) {
            return leftHand * rightHand;
        }

        throw new IllegalArgumentException("지원하지 않는 연산자");
    }

}
