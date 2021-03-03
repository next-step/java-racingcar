package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    private final Map<String, String> matchOperation = new HashMap<String, String>(){{
        matchOperation.put("+", "PLUS");
        matchOperation.put("-", "MINUS");
        matchOperation.put("*", "MULTIPLE");
        matchOperation.put("/", "DIVIDE");
    }};

    public void isBlankOrNull(String data) {
        if (data.equals("") || data == null) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백이면 에러가 발생합니다.");
        }
    }

    public void isOperation(String data) {
        if (!data.equals("+") && !data.equals("-") && !data.equals("*") && !data.equals("/")) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    public int getResult(String input) {
        String datas[] = input.split(" ");
        String operation = "";

        int result = Integer.parseInt(datas[0]);
        for (int i=1; i < datas.length; i+=2) {
            isBlankOrNull(datas[i]);
            isOperation(datas[i]);
            operation = matchOperation.get(datas[i]);
            result = Calculator.valueOf(operation).calculate(result, Integer.parseInt(datas[i+1]));
        }
        System.out.println(result);
        return result;
    }
}
