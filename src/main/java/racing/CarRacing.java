package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private static final String INPUT_CAR_COUNT_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_ROUND_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";
    private List<Car> cars = new ArrayList<>();
    private int rounds = 0;
    private int carCount = 0;

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
    }

    public CarRacing() {
        prepare();
    }

    public CarRacing(int carCount, int rounds) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.rounds = rounds;
    }

    public int carsCount() {
        return cars.size();
    }

    public int rounds() {
        return rounds;
    }

    private void prepare() {
        participateCars();
        setRounds();
    }

    private void setRounds() {
        this.rounds = InputView.input(INPUT_ROUND_COUNT_TEXT);
    }

    private void participateCars() {
        int carCount = InputView.input(INPUT_CAR_COUNT_TEXT);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }
}
