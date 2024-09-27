package uiview;

import car.RacingCar;

import java.util.List;

public class ResultView {

    //현재 레이싱결과를 출력한다.
    public void resultView(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.result();
        }
        System.out.println();
    }

}
