package racinggame;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    public static final int MIN_CAR_QUANTITY = 1;
    private final List<Car> cars;

    public Cars(String carNameString) {
        List<String> carNameList = parseCarNameString(carNameString);
        int carQuantity = carNameList.size();
        Preconditions.checkArgument(carQuantity >= MIN_CAR_QUANTITY, "자동차 숫자는 1 이상이어야 합니다.");

        List<Car> carList = new ArrayList<>();
        carNameList.forEach((carName) -> carList.add(new Car(carName)));
        this.cars = carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    private static List<String> parseCarNameString(String carNameString) {
        String[] carNameArray = carNameString.split(",");
        List<String> carNameList = Arrays.asList(carNameArray);

        Preconditions.checkArgument(!carNameList.contains(""), "자동차 이름은 빈값이 될 수 없습니다.");

        return carNameList;
    }
}
