package racingcar.controller;


import racingcar.service.dto.RacingCarDto;

import java.util.List;

public class ResultView {


    private ResultView() {

    }

    public static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }


    public void printRacingCarsStatus(List<RacingCarDto> racingCars) {
        StringBuilder sb = new StringBuilder();
        for (RacingCarDto racingCar : racingCars) {
            sb.append(racingCar.getName());
            sb.append(" : ");
            sb.append(getPosition(racingCar.getPosition()));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            addComma(winners, i, sb);
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }

    private static void addComma(List<String> winners, int i, StringBuilder sb) {
        if (i != winners.size() - 1) {
            sb.append(", ");
        }
    }

    private String getPosition(Integer position) {
        return "-".repeat(position);
    }
}
