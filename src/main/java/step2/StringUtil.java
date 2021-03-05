package step2;

public class StringUtil {
    private String inputString;

    public StringUtil(String inputString) {

        this.inputString = inputString;

        if(isIllegalArgument()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isIllegalArgument() {
        return inputString == null || "".equals(inputString.trim()) ? true : false;
    }

    public String[] splitBySpace() {
        return inputString.split(" ");
    }
}
