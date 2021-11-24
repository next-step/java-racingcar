package racingcar;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String carNames = inputView.nextLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int racingCount = inputView.next("시도할 횟수는 몇 회 인가요?");

        RacingCar racingCar = RacingCar.create(carNames, racingCount);
        racingCar.start();

        inputView.close();
    }
}
