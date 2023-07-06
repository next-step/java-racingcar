package calculator;

public class Calculator {

    public static int sum(String num) {
        return new Numbers(new Tokenizer().tokenNum(num)).sum();
    }
}
