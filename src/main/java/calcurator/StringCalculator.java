package calcurator;


public class StringCalculator {

    public static int calculate(String input){

        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] inputStr = input.split(" ");
        int num = 0;

        for (int i = 0; i < inputStr.length; i++) {

            if (i == 0) {
                num = Integer.valueOf(inputStr[i]);
            }

            if (inputStr[i].equals("+")) {
                num = Calculator.add(num, Integer.valueOf(inputStr[i + 1]));
                i++;
            }

            if (inputStr[i].equals("-")) {
                num = Calculator.subtract(num, Integer.valueOf(inputStr[i + 1]));
                i++;
            }

            if (inputStr[i].equals("*")) {
                num = Calculator.multiply(num, Integer.valueOf(inputStr[i + 1]));
                i++;
            }

            if (inputStr[i].equals("/")) {
                num = Calculator.division(num, Integer.valueOf(inputStr[i + 1]));
                i++;
            }

        }

        return num;

    }
}
