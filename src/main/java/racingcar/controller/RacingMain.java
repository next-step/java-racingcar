package racingcar.controller;

import racingcar.InputView;
import racingcar.domain.Cars;

public class RacingMain {
    private static InputView inputView = new InputView();
    private static Cars cars;

    public static void main(String[] args) {

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)\n");
        cars = inputView.enterCarNames();

        System.out.print("시도할 횟수는 몇 회 인가요?");
        inputView.enterNumberOfGames(cars);

    }
}
