package calculator;

public class BlankEraser {
    private static final String BLANK = " ";

    public String[] erase(String text) {
        return text.split(BLANK);
    }
}
