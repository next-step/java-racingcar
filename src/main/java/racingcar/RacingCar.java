package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCar {
    public static final String CAR_NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String MOVE_COUNT_INPUT_MSG = "시도할 회수는 몇 회 인가요?";
    public static final int BOUND = 10;
    public static final String RESULT_MSG = "\n실행 결과";

    public static void main(String[] args) {
        String carNameInput = InputView.nameInput(CAR_NAME_INPUT_MSG);
        int moveCount = InputView.userInput(MOVE_COUNT_INPUT_MSG);

        Cars cars = makeCarList(carNameInput);

        ResultView.output(RESULT_MSG);
        for (int i = 0; i < moveCount; i++) {
            cars.move();
            ResultView.resultOutput(cars);
            ResultView.output("");
        }

        List<Car> winnerList = Winner.findWinner(cars);
        ResultView.winnerOutput(winnerList);
    }

    protected static int getRandom() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }

    static Cars makeCarList(String carNameInput) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArr = carNameInput.split(",");
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }

        return new Cars(carList);
    }

}
