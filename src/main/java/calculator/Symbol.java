package calculator;

public class Symbol {
    private final static String SYMBOL_REGEX = "^[+\\-*/]*$";
    private final String item;
    public Symbol(String input) {
        // 유효성 검증
        if (input == null || input.isEmpty() || !input.matches(SYMBOL_REGEX)) {
            throw new IllegalArgumentException();
        }
        this.item = input;
    }
    public String getItem() {
        return item;
    }
}
