public class Calculator {
    public static int splitAndSum(String input) {
        int sum = 0;
        if(input == null || input.isBlank()){
            return sum;
        }

        String[] numbers = input.split(",");
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
