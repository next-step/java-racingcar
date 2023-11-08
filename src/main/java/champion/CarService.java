package champion;

import java.util.*;

public class CarService {
    private static final Random random = new Random();
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static List<Car> generate(String[] names) {
        List<Car> cars = new ArrayList<Car>();

        for (String name : names) {
            validateCarNameLength(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    public static List<String> winChampionList(List<Car> cars) {
        List<String> list = new ArrayList<String>();
        int max = maxCarPosition(cars);

        for (Car car : cars) {
            if (max == car.currentPosition()) {
                list.add(car.carName());
            }
        }

        return list;
    }

    private static int maxCarPosition(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            if (max < car.currentPosition()) {
                max = car.currentPosition();
            }
        }
        return max;
    }

    private static int randomValue() {
        return random.nextInt(10);
    }

    public static void repeatMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValue());
        }
    }

    private static void validateCarNameLength(String name) {
        if (isNameEmpty(name) || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 까지 입력 가능합니다.");
        }
    }

    private static boolean isNameEmpty(String name) {
        return name == null || name.isBlank();
    }


}
