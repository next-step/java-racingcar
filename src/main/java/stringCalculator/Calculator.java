package stringCalculator;

public class Calculator {

    public int main(String input) {
        String[] splitString = splitString(input);
        int total = Integer.parseInt(splitString[0]);

        for (int i = 1; i < splitString.length; i += 2) {
            String operator = splitString[i];
            int target = Integer.parseInt(splitString[i+1]);

            if(operator.equals("+")) {
                total += target;
            }

            if(operator.equals("-")) {
                total -= target;
            }

            if(operator.equals("*")) {
                total *= target;
            }

            if(operator.equals("/")) {
                total /= target;
            }
        }

        return total;
    }

    private String[] splitString(String input) {
        return input.split(" ");
    }
}
