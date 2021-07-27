package racing.view;

import racing.model.CarModel;
import racing.model.RacingModel;

import java.util.List;

public class RacingView {

    private static final String moveText = "-";

    void printMoveLine(int carMove) {
        for (int i=0; i<carMove; i++) {
            System.out.print(moveText);
        }
        System.out.println("");
    }

    public void printCarMove(RacingModel racingModel) {
        racingModel.participants()
                .carList()
                .stream()
                .forEach(car -> printMoveLine(car.totalDistance()));
        System.out.println("");
    }

}
