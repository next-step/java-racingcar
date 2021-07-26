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
    }

    public void printCarMove(RacingModel racingModel) {
        List<CarModel> carList = racingModel.participants();
        for (CarModel car : carList) {
            printMoveLine(car.totalDistance());
            System.out.println("");
        }
        System.out.println("");
    }

}
