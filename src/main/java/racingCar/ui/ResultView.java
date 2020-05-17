package racingCar.ui;

import org.omg.CORBA.Environment;
import racingCar.domain.RacingCar;

import java.util.List;

public class ResultView {
    private StringBuilder stringBuilder;

    public void printCarsPosition(List<RacingCar> racingCarList) {
        stringBuilder = new StringBuilder();

        for (RacingCar racingCar : racingCarList) {
            printPosition(racingCar);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private void printPosition(RacingCar racingCar) {
        for (int idx = 0; idx < racingCar.getPosition(); idx++) {
            stringBuilder.append("-");
        }
    }
}
