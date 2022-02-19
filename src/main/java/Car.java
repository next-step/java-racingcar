import java.util.Arrays;
import java.util.Random;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public boolean isValid() {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public void moveRandom(Random random) {
        int randomInt = random.nextInt(10);
        if (randomInt >= 4) {
            position++;
        }
    }

    public void printPosition() {
        System.out.println(carName + " : " + getPositionAsString());
    }

    private String getPositionAsString() {
        char[] array = new char[position];
        Arrays.fill(array, '-');
        return new String(array);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
