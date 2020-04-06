package racingcar;

import java.util.*;

public class RacingController {
    public static final int FIRST = 1;
    public static final int NUMBER_GENERATE_RANGE = 10;
    private static final String CAR_NAME_REQUIRED_ERROR = "자동차 이름은 값이 존재해야 합니다.";

    private int tryCount;
    private Cars cars;
    private Map<Integer, List<Integer>> record;

    public RacingController(InputView inputView) {
        this.cars = createCar(inputView.getCarNames());
        tryCount = inputView.getTryCount();
        record = new HashMap<>();
    }

    public void startGame() {
        gameStart();
        showResult();
    }

    private List<Integer> changePosition() {
        List<Car> tempCars = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars.getCars()) {
            Car movedCar = car.changeCarPosition(car, getRandomNUmber());
            positions.add(movedCar.getPosition());
            tempCars.add(new Car(movedCar.getName(), movedCar.getPosition()));
        }
        cars = new Cars(tempCars);
        return positions;
    }

    private Cars createCar(String carNames) {
        List<Car> tempCars = new ArrayList<>();

        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_REQUIRED_ERROR);
        }
        String[] names = carNames.split(",");

        for (String name : names) {
            tempCars.add(new Car(name));
        }
        return new Cars(tempCars);
    }

    private int getRandomNUmber() {
        Random random = new Random();
        return random.nextInt(NUMBER_GENERATE_RANGE);
    }

    private void gameStart() {
        for (int count = FIRST; count <= tryCount; count++) {
            record.put(count, changePosition());
        }
    }

    private void showResult() {
        ResultView resultView = new ResultView(this.record, this.cars);
        resultView.show();
    }


}
