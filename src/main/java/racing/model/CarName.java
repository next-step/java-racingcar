package racing.model;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String title;

    public CarName(String title) {
        checkNameIsPossible(title);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private void checkNameIsPossible(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(name + " is over " + MAX_NAME_LENGTH + " letters");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(title, carName.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
