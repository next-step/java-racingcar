package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    private final List<Car> cars;
    private final int roundNum;
    private final ResultView resultView;

    public Racing(List<Car> cars, int roundNum, ResultView resultView) {
        this.cars = cars;
        this.roundNum = roundNum;
        this.resultView = resultView;
    }

    public void start() {
        for (int i = 0; i < roundNum; i++) {
            resultView.roundStart(i + 1);
            play();
        }
    }

    private void play() {
        for (Car car : cars) {
            int position = car.move(RANDOM.nextInt(10));
            resultView.drawCarPosition(position);
        }
    }

}
