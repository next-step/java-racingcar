package step2.race.controller;

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
        for (int position : raceHistory.getHistory()) {
            showEachCar(position);
        }
        System.out.println();
    }

    private void showEachCar(int position) {
        StringBuilder carPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            carPosition.append(POSITION);
        }
        System.out.println(carPosition.toString());
    }


}
