package stage2.stringcalculator;

public class StringCalculator {

    public static int calculation(String inputString) throws Exception {

        System.out.println("입력한 문자열 : " + inputString);

        String[] inputArray = inputString.split(" ");

        int before = getParseInt(inputArray[0]);
        int after = getParseInt(inputArray[2]);

        return ArithmeticOperation.arithmetic(inputArray[1]).calculation(before, after);
    }

    private static int getParseInt(String inputArray) {
        return Integer.parseInt(inputArray);
    }
}
