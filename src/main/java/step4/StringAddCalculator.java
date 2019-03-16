package step4;

public class StringAddCalculator {

    public int add(String str) {
        int total =0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] numbers = str.split(",");
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;

    }

}
