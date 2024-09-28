package step2;

import step2.delimiter.DelimiterNumberParserFactory;

public class Application {
    public static void main(String[] args) {
        new StringAddCalculator(new DelimiterNumberParserFactory());
    }
}
