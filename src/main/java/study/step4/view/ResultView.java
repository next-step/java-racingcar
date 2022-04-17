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

    public void start() {
        System.out.println("실행 결과");
    }

    public void winners(List<String> winners) {
        System.out.println(winners + "가 최종 우승했습니다");

    }
}
