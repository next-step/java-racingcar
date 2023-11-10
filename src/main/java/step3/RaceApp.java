package step3;

import java.util.List;

public class RaceApp {
    public static void main(String[] args) {
        String carNames = InputView.readStringInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (!CarName.verifyCarNames(carNames)) {
            return;
        }
        MoveCarStatus moveCarStatus = new MoveCarStatus(CarName.splitCarNames(carNames), 0);
        int tryCount = InputView.readIntInput("시도할 회수는 몇회인가요?");
        int decisionValue = InputView.readIntInput("전진할 기준값은 10을 기준으로 얼마인가요?");

        MoveCars moveCars = new MoveCars(tryCount, decisionValue);
        moveCars.process(moveCarStatus, new ResultView());

        RaceWinner raceWinner = new RaceWinner();
        raceWinner.printWinner(raceWinner.getWinners(moveCarStatus.getCars()));


    }
}
