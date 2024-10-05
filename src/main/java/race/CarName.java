package race;

import java.util.Objects;

public class CarName {
    private final String value;

    public CarName(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CarName))
            return false;
        CarName carName = (CarName)o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
