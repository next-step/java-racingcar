package study.step4.view;

import study.step4.controller.CarsPositionModel;

import java.util.List;

public class ResultView {
    private static final String DISPLAY_CAR = "-";
    private static final String COMMA = ",";
    private static final String DELIMITER = " :";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public void printPlay(List<CarsPositionModel> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.getCarName())
                .append(DELIMITER)
                .append(toMarker(car))
                .append(System.lineSeparator());
        });
        System.out.println(sb);
    }

    public void plintln() {
        System.out.println("");
    }

    public void start() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void winners(List<String> winners) {
        System.out.println(String.join(COMMA, winners) + "가 최종 우승했습니다");
    }

    private String toMarker(CarsPositionModel car) {
        return DISPLAY_CAR.repeat(Math.max(0, car.getPosition()));
    }
}
