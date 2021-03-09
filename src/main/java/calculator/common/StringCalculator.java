package calculator.common;


public class StringCalculator {

    public static void main(String[] args) {
        String inputData = "2 + 3 * 4 / 2";

        if ("".equals(inputData) || inputData == null)
            throw new IllegalArgumentException();

        String[] inputDataArr = inputData.split(" ");
        int prevNumber = Integer.parseInt(inputDataArr[0]);
        int postNumber;
        int result = 0;

        for (int idx = 1; idx <= inputDataArr.length/2; idx+=2) {
            postNumber = Integer.parseInt(inputDataArr[idx+1]);

            result = calculation(inputDataArr[idx], prevNumber, postNumber);
            prevNumber = result;

        }
        System.out.println("result --> " + result);
    }

    private static int calculation(String mark, int prevNumber, int postNumber) {
        if ("+".equals(mark))
            return CalculatorType.ADD.calculate(prevNumber, postNumber);

        if ("-".equals(mark))
            return CalculatorType.SUBTRACTION.calculate(prevNumber, postNumber);

        if ("*".equals(mark))
            return CalculatorType.MULTIPLICATION.calculate(prevNumber, postNumber);

        if ("/".equals(mark))
            return CalculatorType.DIVISION.calculate(prevNumber, postNumber);

        return 0;
    }
}
