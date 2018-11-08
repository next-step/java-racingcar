package racingcar.view;

import racingcar.RacingGame;
import racingcar.RacingResult;
import racingcar.domain.Car;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        RacingResult racingResult;

        String carNames = InputView.getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int playTime = InputView.getInputNumber("시도할 회수는 몇회인가요?");

        // 차량 준비
        racingGame.readyCars(carNames);

        // 레이싱 회수만 큼 시작
        for (int i=0; i<playTime; i++) {
            List<Car> cars = racingGame.startRacing();

            ResultView.showResult(cars);

            System.out.println();
        }

        // 게임 결과 출력
        racingResult = new RacingResult(racingGame.getCars());
        ResultView.showWinners(racingResult.getWinners());
    }
}
