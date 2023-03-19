package calculator;

public class Calculator_Move extends Calculator_Abstract {

    public int caculate(String text) {

        int calculate_result = 0;
        int nextnumber;
        String[] sub_text = text.split("");

        //입력 받은 문자식이 null 이거나 "" 이면 error
        if ("".equals(text) || text == null) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자일 경우");
        }

        for (int i = 0; i < text.length(); i++) {

            // 숫자와 사칙연산이 아닌경우 error
            if (sub_text[i].matches("[^0-9]") && !sub_text[i].matches("[+\\-*/]")) {
                throw new IllegalArgumentException("사칙연산 기호가 아닌 경우.");
            }

            if (i == 0) calculate_result = Integer.parseInt(sub_text[i]);

            if (sub_text[i].matches("[+\\-*/]")) {
                nextnumber = Integer.parseInt(sub_text[i + 1]);
                calculate_result = calculator(sub_text[i], calculate_result, nextnumber);
            }
        }
        return calculate_result;
    }

    public int calculator(String sentence, int number1, int number2) {

        int result = 0;

        if ("+".equals(sentence)) result = add(number1, number2);
        if ("-".equals(sentence)) result = subtract(number1, number2);
        if ("*".equals(sentence)) result = multiply(number1, number2);
        if ("/".equals(sentence)) result = divide(number1, number2);

        return result;
    }


    //더하기(+)
    public int add(int a, int b) {
        return a + b;
    }

    //뻬기(-)
    public int subtract(int a, int b) {
        return a - b;
    }

    //곱하기(*)
    public int multiply(int a, int b) {
        return a * b;
    }

    //나누기(/)
    public int divide(int a, int b) {
        return a / b;
    }
}
