package uiview;

import car.CarStrategy;

import java.util.List;

public class ResultView {

    //현재 레이싱결과를 출력한다.
    public void resultView(List<CarStrategy> cars) {
        for (CarStrategy carStrategy : cars) {
            carStrategy.result();
        }
        System.out.println();
    }

}
