public class StringCalculator {
    private final String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int calc() {
        String[] split = splitUserInput();
        if (split.length == 1) {
            return parseStrToInt(split[0]);
        }
        return 0;
    }

    private String[] splitUserInput() {
        return text.split("[,:]");
    }

    private int parseStrToInt(String str) {
        return Integer.parseInt(str);
    }

}
