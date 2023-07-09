package calculator;

public class Calculator {

    public static int sum(final String num) {
        return new Numbers(new Tokenizer().tokenNum(num)).sum();
    }
}
