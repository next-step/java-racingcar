package racing.domain.car;

import java.util.*;

public class RacingCars {
    private final List<Car> carPositions;
    private static final String DELIMITER = ",";

    public RacingCars(String inputName) {
        this.carPositions = prepareCars(inputName);
    }

    public List<Car> prepareCars(String inputName) {
        List<Car> carsPositions = new ArrayList<>();

        checkInputName(inputName);

        String[] carNames = inputName.split(DELIMITER);

        for (int i = 0; i < carNames.length; i++) {
            carsPositions.add(new Car(carNames[i]));
        }
        return carsPositions;
    }

    public static void checkInputName(String inputName) {
        if (Objects.isNull(inputName) || inputName.equals(" ")) {
            throw new IllegalArgumentException("이름이 비어있습니다. 이름을 입력해주세요.");
        }
    }

    public void moveCars(CarMoveBehavior carMoveBehavior) {
        for (int i = 0; i < carPositions.size(); i++) {
            carPositions.get(i).move(carMoveBehavior);
        }
    }

    public List<Car> getCars() {
        return carPositions;
    }
}
