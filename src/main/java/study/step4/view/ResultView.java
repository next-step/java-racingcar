package study.step4.view;

import study.step4.controller.CarsPositionModel;

import java.util.List;

public class ResultView {
    public void printPlay(List<CarsPositionModel> cars) {
        cars.forEach(car -> {
            System.out.println(car.getCarName() + " :" + positionDisplay(car));
        });
    }

    private String positionDisplay(CarsPositionModel car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void plintln() {
        System.out.println("");
    }
}
