package calculator2;

public class StringCalculator2 {
    public static int add(String text) {
        String[] texts = StringNumberParser.parse(text);
        StringNumberSet stringNumberSet = StringNumberSet.create(texts);
        return stringNumberSet.sum();
    }
}
