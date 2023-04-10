package racingcar;

import java.util.ArrayList;

public class ResultView {
    public void showCurrentState(ArrayList<CarInfo> carInfos) {
        for (CarInfo carInfo : carInfos) {
            String dashes = "-".repeat(carInfo.getCurrentDistance());
            System.out.println(dashes);
        }
        System.out.println();
    }
}
