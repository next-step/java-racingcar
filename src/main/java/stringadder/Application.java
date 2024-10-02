package stringadder;

import stringadder.delimiter.DelimiterNumberParserFactory;

public class Application {
    public static void main(String[] args) {
        new StringAddCalculator(new DelimiterNumberParserFactory());
    }
}
