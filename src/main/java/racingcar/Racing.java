package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {

    public static final String LINE = "-".repeat(5);
    private final List<Car> cars;
    private final int roundNum;
    private static final Random RANDOM = new Random();

    public Racing(List<Car> cars, int roundNum) {
        this.cars = cars;
        this.roundNum = roundNum;
    }

    public void start() {
        // 첫 번째 라운드는 무조건 강제로 전진
        System.out.println(LINE + "1 라운드 시작!" + LINE);
        playFirstRound();

        for (int i = 1; i < roundNum; i++) {
            System.out.println(LINE + (i + 1) + " 라운드 시작!" + LINE);
            play();
        }
    }

    private void playFirstRound() {
        for (Car car : cars) {
            car.forceMove();
            ResultView.drawCarPosition(car.getCurrentPosition());
        }
    }

    private void play() {
        for (Car car : cars) {
            int position = car.moveCar(RANDOM.nextInt(10));
            ResultView.drawCarPosition(position);
        }
    }


}
