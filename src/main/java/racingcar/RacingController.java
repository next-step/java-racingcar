package racingcar;

import java.util.*;

public class RacingController {
    public static final int FIRST = 1;
    public static final int NUMBER_GENERATE_RANGE = 10;

    private int tryCount;
    private Cars cars;
    Map<Integer, List<Integer>> record;

    public RacingController(InputView inputView) {
        this.cars = createCar(inputView.getCarCount());
        tryCount = inputView.getTryCount();
        record = new HashMap<>();
    }

    public void startGame() {
        gameStart();
        showResult();
    }

    private List<Integer> changePosition(int randomRumber) {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars.getCars()) {
            Car movedCar = car.changeCarPosition(car, randomRumber);
            positions.add(movedCar.getPosition());
        }
        return positions;
    }

    private Cars createCar(int carCount) {
        List<Car> tempCars = new ArrayList<>();
        for (int carNumber = 1; carNumber <= carCount; carNumber++) {
            tempCars.add(new Car(carNumber));
        }
        return new Cars(tempCars);
    }

    private int getRandomNUmber() {
        Random random = new Random();
        return random.nextInt(NUMBER_GENERATE_RANGE);
    }

    private void gameStart() {
        for (int count = FIRST; count <= tryCount; count++) {
            record.put(count, changePosition(getRandomNUmber()));
        }
    }

    private void showResult() {
        ResultView resultView = new ResultView(this.record);
        resultView.show();
    }


}
