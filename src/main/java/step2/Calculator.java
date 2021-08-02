package step2;

import java.util.HashMap;

public enum Calculator {
    SUM{
        int calculate(int num1, int num2){ return num1 + num2; }
    },
    SUBTRACT{
        int calculate(int num1, int num2){ return num1 - num2; }
    },
    MULTIPLY{
        int calculate(int num1, int num2){ return num1 * num2; }
    },
    DIVIDE{
        int calculate(int num1, int num2){ return num1 / num2; }

    };

    abstract int calculate(int num1, int num2);

    public static int multiCalculate(String input) {
        HashMap<String, Calculator> hm = new HashMap<>();
        hm.put("+", SUM);
        hm.put("-", SUBTRACT);
        hm.put("*", MULTIPLY);
        hm.put("/", DIVIDE);

        //빈문자열일 경우
        if (input == null || input.trim().length() == 0){
            throw new IllegalStateException("빈 문자열입니다.");
        }

        //빈칸을 기준으로 나누기
        String[] elements = input.split(" ");

        //숫자랑 기호랑 번가아가면서 들어온다는 가정하에..
        int result = 0;
        for (int i=1; i<elements.length; i+=2) {
            if (!hm.containsKey(elements[i])) {
                throw new IllegalStateException("알맞지 않은 기호입니다.");
            }

            int num1 = changeToDigit(elements[i-1]);
            int num2 = changeToDigit(elements[i+1]);

            Calculator operator = hm.get(elements[i]);
            result = operator.calculate(num1, num2);
            elements[i+1] = String.valueOf(result);
        }

        return result;
    }

    public static int changeToDigit(String input){
        return input.matches("[0-9]*")? Integer.parseInt(input):0;
    }
}
