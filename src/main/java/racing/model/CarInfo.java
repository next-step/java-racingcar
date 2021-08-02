package racing.model;

public class CarInfo {

    private final static int MAX_WORD_NAME = 5;

    private String name;

    public CarInfo(final String name) {
        checkCarName(name);
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    void checkCarName(String name) {
        if (name.length() > MAX_WORD_NAME) {
            throw new IllegalArgumentException();
        }
    }
}
