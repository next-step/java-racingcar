public enum ArithmeticPattern {
    EXPRESSION("\\d+( [-*/+] \\d+)+"),
    OPERATOR("[-*/+]"),
    OPERAND("[0-9]+");

    private final String pattern;

    ArithmeticPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return this.pattern;
    }
}