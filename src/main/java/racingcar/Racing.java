package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {

    public static final String LINE = "-".repeat(5);
    private static final Random RANDOM = new Random();

    private final List<Car> cars;
    private final int roundNum;

    public Racing(List<Car> cars, int roundNum) {
        this.cars = cars;
        this.roundNum = roundNum;
    }

    public void start() {
        for (int i = 0; i < roundNum; i++) {
            System.out.println(LINE + (i + 1) + " 라운드 시작!" + LINE);
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
