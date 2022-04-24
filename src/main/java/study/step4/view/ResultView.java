package study.step4.view;

import study.step4.controller.CarsPositionModel;

import java.util.List;

public class ResultView {
    private static final String DISPLAY_CAR = "-";
    private static final String COMMA = ",";
    private static final String DELIMITER = " :";

    public void printPlay(List<CarsPositionModel> cars) {
        cars.forEach(car -> {
            System.out.println(car.getCarName() + DELIMITER + toMarker(car));
        });
    }

    public void plintln() {
        System.out.println("");
    }

    public void start() {
        System.out.println("실행 결과");
    }

    public void winners(List<String> winners) {
        System.out.println(String.join(COMMA,winners) + "가 최종 우승했습니다");

    }

    private String toMarker(CarsPositionModel car) {
        StringBuilder sb = new StringBuilder();
        sb.append(DISPLAY_CAR.repeat(Math.max(0, car.getPosition())));
        return sb.toString();
    }
}
