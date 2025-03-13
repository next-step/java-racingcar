public class StringCalculator {
    private final String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int calc() {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        String[] split = splitUserInput();
        if (split.length == 1) {
            return parseStrToInt(split[0]);
        }
        return 0;
    }

    private boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    private String[] splitUserInput() {
        return text.split("[,:]");
    }

    private int parseStrToInt(String str) {
        return Integer.parseInt(str);
    }

}
