package step2;

public class StringCalculator {
    public Integer splitAndAdd(String text) {
        Integer sum = 0;
        String[] numbers = text.split(":|,");

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
