package calculator;

public class Delimiter {
    public static final String SPECIAL_SYMBOL = ".*[\\. \\[ \\] \\ \\{ \\} \\* \\+ \\? \\^ \\$ \\( \\) \\|].*";
    private final String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String valueOfRegex() {
        if(delimiter.matches(SPECIAL_SYMBOL)){
            return toRegex();
        }
        return delimiter;
    }

    private String toRegex() {
        String[] delimiters = delimiter.split("");
        String delimiterForRegex = "";
        for (String s : delimiters) {
            delimiterForRegex += toRegexSymbol(s);
        }
        return delimiterForRegex;
    }

    private static String toRegexSymbol(String delimiter) {
        if(delimiter.matches(SPECIAL_SYMBOL)){
            return "\\" + delimiter;
        }
        return delimiter;
    }
}
