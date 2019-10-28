package step2.race.controller;

import step2.car.domain.Status;
import step2.race.domain.RaceHistory;

import java.util.List;

public class OutputView {
    private static final String POSITION = "-";

    public void showResult(List<RaceHistory> raceHistories) {
        System.out.println("실행결과");
        for (RaceHistory raceHistory : raceHistories) {
            showHistory(raceHistory);
        }
    }

    private void showHistory(RaceHistory raceHistory) {
        for (Status status : raceHistory.getHistory()) {
            showEachCar(status);
        }
        System.out.println();
    }

    private void showEachCar(Status status) {
        StringBuilder carPosition = new StringBuilder(status.getName());
        for (int i = 0; i < status.getPosition(); i++) {
            carPosition.append(POSITION);
        }
        System.out.println(carPosition.toString());
    }


}
