package step2;

public class CalculatorType {

    public static int calculator(String text) {
        //빈 문자열 기준 split
        String[] values = text.split(" ");
        //처음 수를 reulst에 담기
        int result = Integer.parseInt(values[0]);
        //처음의 다음 수 부터 반복 (연산자만 들어감)
        for (int i = 1, len = values.length; i < len; i+=2) {
            String operator = values[i];//첫 연산자를 담아줌
            int target = Integer.parseInt(values[i + 1]);//피연산자를 정수형으로 변환
            result = CalculatorType.calculate(result, target, operator);//피연산자 1,피연산자2,연산자
        }

        return result;
    }

    public static int calculate(int source, int target, String operator) {
        if (operator.equals("+")) {
            return source + target;
        }

        if (operator.equals("-")) {
            return source - target;
        }

        if (operator.equals("*")) {
            return source * target;
        }

        if (operator.equals("/")) {
            return source / target;
        }

        return 0;
    }
}
