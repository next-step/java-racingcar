package step3;

import step3.domain.RacingGame;
import step3.view.InputScanner;

public class Main {
    public static void main(String[] args) {
        String inputNamesOfCars = InputScanner.getString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int inputNumberOfTry = InputScanner.getInt("시도할 회수는 몇 회 인가요?");

        RacingGame racingGame = new RacingGame(
                inputNamesOfCars,
                inputNumberOfTry
        );

        racingGame.racingAll();
    }
}
