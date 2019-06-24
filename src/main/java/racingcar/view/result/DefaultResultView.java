package racingcar.view.result;

import racingcar.dto.GameResult;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.RacingCars;
import racingcar.domain.model.Winners;

public class DefaultResultView implements ResultView {

    @Override
    public void print(GameResult gameResult) {
        printHeader();
        gameResult.getSnapshot().stream()
                .forEach(this::printBody);
        printFooter(gameResult.getWinners());
    }

    private void printHeader() {
        System.out.println("\n실행 결과");
    }

    private void printBody(RacingCars racingCars) {
        racingCars.findAll().stream()
                .forEach(this::printCar);
        System.out.println();
    }

    private void printCar(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        for (int i = 0; i < racingCar.getPosition().get(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printFooter(Winners winners) {
        System.out.println(winners.getNames() + "가 최종 우승했습니다.");
    }
}