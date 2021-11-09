package racingcar;

public class Makable {
    private static final int MAX_LENGTH = 5;

    public boolean valid(String name) {
        if (name.length() > MAX_LENGTH) {
            return false;
        }

        return true;
    }
}
