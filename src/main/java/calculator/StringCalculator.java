package calculator;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank())
            return 0;

        Parser parser = new Parser(text);
        Splitter splitter = new Splitter(parser.findText(), parser.findDelimiter());

        String[] numbers = splitter.split();
        int sum = sum(toInts(numbers));
        return sum;
    }

    public static int sum(int[] numbers) {
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }

    public static int[] toInts(String[] texts) {
        int[] numbers = new int[texts.length];
        for(int i = 0; i < texts.length; i++) {
            numbers[i] = toInt(texts[i]);
        }
        return numbers;
    }

    public static int toInt(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

}
