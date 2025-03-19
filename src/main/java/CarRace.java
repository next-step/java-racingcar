import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final ResultView result = new ResultView();
    private final List<Car> cars = new ArrayList<>();

    public void ready() {
        InputView input = new InputView();
        int carCount = input.scanPositiveInt("자동차 대수는 몇 대 인가요?");
        int raceCount = input.scanPositiveInt("시도할 회수는 몇 회 인가요?");

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        result.printStart();
        for (int i = 0; i < raceCount; i++) {
            race();
            show();
        }
    }

    private void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void show() {
        for (Car car : cars) {
            result.printDash(car.getPosition());
        }
        result.printFinish();
    }

}
