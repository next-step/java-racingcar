package racingcar.view;

import racingcar.entity.RacingCar;

import java.util.List;

public class ResultView {
    public void printRacingCarsPosition(List<RacingCar> racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            printPosition(racingCars.get(i).getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
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
