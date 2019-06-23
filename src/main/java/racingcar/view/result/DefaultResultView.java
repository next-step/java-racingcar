package racingcar.view.result;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Winners;

import java.util.List;

public class DefaultResultView implements ResultView {

    @Override
    public void printHeader() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printBody(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printCar(racingCar);
        }
        System.out.println();
    }

    private void printCar(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void printFooter(Winners winners) {
        System.out.println(winners.getNames() + "가 최종 우승했습니다.");
    }
}