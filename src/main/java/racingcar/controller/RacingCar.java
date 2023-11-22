package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerate;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    public static final String CAR_NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String MOVE_COUNT_INPUT_MSG = "시도할 회수는 몇 회 인가요?";
    public static final int BOUND = 10;
    public static final String RESULT_MSG = "\n실행 결과";

    public static void main(String[] args) {
        String carNameInput = InputView.nameInput(CAR_NAME_INPUT_MSG);
        int moveCount = InputView.userInput(MOVE_COUNT_INPUT_MSG);

        Cars cars = new Cars(carNameInput);

        ResultView.output(RESULT_MSG);
        for (int i = 0; i < moveCount; i++) {
            cars.move(new NumberGenerate() {
                @Override
                public int generate() {
                    return getRandom();
                }
            });
            ResultView.resultOutput(cars);
            ResultView.output("");
        }

        List<Car> winnerList = cars.findWinner();
        ResultView.winnerOutput(winnerList);
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
