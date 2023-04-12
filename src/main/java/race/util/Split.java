package race.util;

public class Split {

    private final String text;

    private static final String DELIMITER = ",";

    public Split(String text) {
        this.text = text;
    }

    public String[] getResult() {
        return this.text.split(DELIMITER);
    }
}
