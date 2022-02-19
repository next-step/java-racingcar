import java.util.Arrays;
import java.util.List;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public boolean isValid() {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public String getCarName() {
        return carName;
    }
}
