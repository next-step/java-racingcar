package game;

import game.domain.Cars;
import game.view.InputView;
import game.view.ResultView;

import java.util.List;

/**
 * 기능 요구사항
 * <pre>
 *     초간단 자동차 경주 게임을 구현한다.
 *     주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 *     사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 *     전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 *     자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 * </pre>
 */
public class CarRacingApplication {

    public static void main(String[] args) {
        List<String> carNames = InputView.showAndGetCarNames();
        int racingRep = InputView.showAndGetRacingRep();
        throwIfNegativeNumber(racingRep);

        Cars cars = Cars.of(carNames);
        ResultView.displayExecuteResultMessage();
        for (int i = 0; i < racingRep; i++) {
            cars.drive();
            ResultView.displayCarPositions(cars);
        }
        ResultView.displayCarWinners(cars.findWinners());
    }

    private static void throwIfNegativeNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }
}