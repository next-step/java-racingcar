package calculator.common;

public class StringCalculator {

    private final String EMPTY_STRING = "";
    private final String DELIMITER = " ";

    public int calculator(String data) {
        checkValidData(data);

        String[] inputDataArr = data.split(DELIMITER);
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
        if (EMPTY_STRING.equals(inputData) || inputData == null)
            throw new IllegalArgumentException();
    }

    private int calculation(String mark, int prevNumber, int postNumber) {

        for (CalculatorType type : CalculatorType.values()) {
            if (type.getMark().equals(mark))
                return type.calculate(prevNumber, postNumber);
        }

        throw new IllegalArgumentException();
    }
}
