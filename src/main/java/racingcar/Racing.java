package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    private final List<Car> cars;
    private final int roundNum;

    public Racing(List<Car> cars, int roundNum) {
        this.cars = cars;
        this.roundNum = roundNum;
    }

    public void start() {
        for (int i = 0; i < roundNum; i++) {
            ResultView.roundStart(i + 1);
            play();
        }
    }

    private void play() {
        for (Car car : cars) {
            int position = car.moveCar(RANDOM.nextInt(10));
            ResultView.drawCarPosition(position);
        }
    }

}
