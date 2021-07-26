package racingcar.view;

import racingcar.entity.RacingCar;

import java.util.List;

public class ResultView {
    public void printRacingCarsPosition(List<RacingCar> racingCars) {
        for (RacingCar racingCar: racingCars) {
            printPosition(racingCar.getPosition());
        }
        System.out.println();
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void printResultFirstLine() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
