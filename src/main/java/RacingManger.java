import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class RacingManger {

    public static final String DELIMITER = ",";
    public static final int NAME_LENGTH_LIMIT = 5;
    private Car[] cars;

    public RacingManger(String carString) {
        makeCars(carString);
    }

    private Car[] makeCars(String carString) {
        final String[] carNames = carString.split(DELIMITER);
        validNameLength(carNames);
        this.cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            this.cars[i] = new Car(carNames[i]);
        }
        return this.cars;
    }

    private static void validNameLength(String[] carNames) {
        for (String carName : carNames) {
            throwWhenExceedLimitLength(carName);
        }
    }

    private static void throwWhenExceedLimitLength(String carName) {
        if (carName.length() > NAME_LENGTH_LIMIT) {
            throw new IndexOutOfBoundsException("name length exceed");
        }
    }

    public void play() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public Car[] getCars() {
        return this.cars;
    }

    public String getWinners() {
        int maxPosition = 0;
        final HashMap<Integer, List<String>> winnersMap = new HashMap<>();
        for (Car car : this.cars) {
            final int carPosition = car.getPosition();
            maxPosition = getMaxPosition(car, maxPosition, carPosition, winnersMap);
        }

        return String.join(DELIMITER, winnersMap.get(maxPosition));
    }

    private static int getMaxPosition(Car car, int maxPosition, int carPosition, HashMap<Integer, List<String>> winnersMap) {
        if (maxPosition <= carPosition) {
            maxPosition = carPosition;
            fillWinnerIntoMap(car, maxPosition, winnersMap);
        }
        return maxPosition;
    }

    private static void fillWinnerIntoMap(Car car, int maxPosition, HashMap<Integer, List<String>> winnersMap) {
        if (Objects.isNull(winnersMap.get(maxPosition))) {
            final List<String> newList = new ArrayList<>();
            newList.add(car.getName());
            winnersMap.put(maxPosition, newList);
            return;
        }

        winnersMap.get(maxPosition).add(car.getName());
    }
}
