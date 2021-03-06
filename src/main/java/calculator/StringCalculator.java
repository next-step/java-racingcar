package calculator;

public class StringCalculator {

    private String[] inputDatas;
    private int result = 0;

    public StringCalculator(String userInput) {
        inputDatas = userInput.split(" ");
    }

    public void checkInputValue(String userInput) {
        if (userInput == null || userInput.equals(" ")) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }

    public boolean isDigit(String data) {
        return Character.isDigit(data.charAt(0));
    }

    private int receivedCalculate(String[] data, int temp, int index) {
        if (!isDigit(data[index])) {
            temp = calculate(Integer.toString(temp), selectCode(data[index]), data[index + 1]); // 앞에서 연산한 값을 누적시킨 후, 뒤에 피연산자와 다시 연산을 반복
        }
        return temp;
    }

    private int calculate(String operand, CalculatorType code, String operand1) {

        int calculateResult = code.calculate(Integer.parseInt(operand), Integer.parseInt(operand1));

        return calculateResult;
    }

    private CalculatorType selectCode(String operator) {

        return CalculatorType.calculatorType(operator);
    }

    public int returnResult(String[] data) {

        int temp = Integer.parseInt(data[0]); // 맨 처음 연산할 때 피연산자 값을 가져온다.

        for (int i = 0; i < data.length; i++) {
            temp = receivedCalculate(data, temp, i);
        }

        result = temp;

        return result;

    }






}
