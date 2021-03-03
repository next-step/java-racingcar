package calculator;

public class StringCalculator {

    String[] inputDatas;

    int result = 0;
    int temp = 0;

    public StringCalculator(String userInput) {
        checkInputValue(userInput);
        inputDatas = userInput.split(" ");
        calculate(inputDatas);
    }


    // 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    public void checkInputValue(String userInput) {
        if (userInput == null || userInput.equals(" ")) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }

    public void calculate(String[] data) {

        temp = Integer.parseInt(inputDatas[0]);

        for (int i = 0; i < data.length; i++) {
            if (!isDigit(data[i])) {
                findOperation(data[i], data[i + 1]);
            }
        }

        result = temp;
        System.out.println(result);

    }

    // 숫자인지 연산자인지 구분하기 위해
    public boolean isDigit(String data) {
        return Character.isDigit(data.charAt(0));
    }

    private void findOperation(String operator, String operand) {

        switch (operator) {
            case "+":
                additional(Integer.parseInt(operand));
                break;
            case "-":
                substraction(Integer.parseInt(operand));
                break;
            case "*":
                multiplication(Integer.parseInt(operand));
                break;
            case "/":
                division(Integer.parseInt(operand));
                break;
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }


    // 사칙연산별 메소드
    public int additional(int operand) {
        return temp += operand;
    }

    public int substraction(int operand) {
        return temp -= operand;
    }

    public int multiplication(int operand) {
        return temp *= operand;
    }

    public int division(int operand) {
        return temp /= operand;
    }


}
