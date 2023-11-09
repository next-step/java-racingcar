package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    public static final String CAR_COUNT_INPUT_MSG = "자동차 대수는 몇 대 인가요?";
    public static final String MOVE_COUNT_INPUT_MSG = "시도할 회수는 몇 회 인가요?";
    public static final int BOUND = 10;
    public static final String RESULT_MSG = "\n실행 결과";

    public static void main(String[] args) {
        int carCount = InputView.userInput(CAR_COUNT_INPUT_MSG);
        int moveCount = InputView.userInput(MOVE_COUNT_INPUT_MSG);

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        ResultView.output(RESULT_MSG);
        for (int i = 0; i < moveCount; i++) {
            for (Car car : carList) {
                car.move(getRandom());
                ResultView.resultOutput(car.getDistance());
            }
            ResultView.output("");
        }
    }

    protected static int getRandom() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
