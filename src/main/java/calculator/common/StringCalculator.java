package calculator.common;


public class StringCalculator {

    public int calculator(String data) {
        checkValidData(data);

        String[] inputDataArr = data.split(" ");
        int prevNumber = Integer.parseInt(inputDataArr[0]);
        int postNumber;
        int result = 0;

        for (int idx = 1; idx <= inputDataArr.length / 2; idx += 2) {
            postNumber = Integer.parseInt(inputDataArr[idx + 1]);

            result = calculation(inputDataArr[idx], prevNumber, postNumber);
            prevNumber = result;
        }
        return result;
    }

    private void checkValidData(String inputData) {
        if ("".equals(inputData) || inputData == null)
            throw new IllegalArgumentException();
    }

    private int calculation(String mark, int prevNumber, int postNumber) {
        if ("+".equals(mark))
            return CalculatorType.ADD.calculate(prevNumber, postNumber);

        if ("-".equals(mark))
            return CalculatorType.SUBTRACTION.calculate(prevNumber, postNumber);

        if ("*".equals(mark))
            return CalculatorType.MULTIPLICATION.calculate(prevNumber, postNumber);

        if ("/".equals(mark))
            return CalculatorType.DIVISION.calculate(prevNumber, postNumber);

        throw new IllegalArgumentException();
    }
}
