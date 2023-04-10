package calculator;

public class Splitter {

    private String text;

    public Splitter(String text) {
        this.text = text;
    }

    public int[] split() {
        String delimiter = Parser.findDelimiter(text);
        text = Parser.findText(text);

        return toInts(text.split(delimiter));
    }

    private static int[] toInts(String[] texts) {
        int[] numbers = new int[texts.length];
        for(int i = 0; i < texts.length; i++) {
            numbers[i] = toInt(texts[i]);
        }
        return numbers;
    }

    private static int toInt(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new NegativeNumberException("문자열 중 음수가 포함되었습니다.");
        }
        return number;
    }
}
