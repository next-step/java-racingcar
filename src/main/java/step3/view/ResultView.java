package step3.view;

import step3.domain.RacingCar;
import step3.domain.RacingCars;

public class ResultView {

    public void printRacingCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.list()) printRacingCar(racingCar.position());
        System.out.println();
    }

    public void printRacingCar(int position) {
        for (int i = 0; i < position; i++) System.out.print("-");
        System.out.println();
    }

}
