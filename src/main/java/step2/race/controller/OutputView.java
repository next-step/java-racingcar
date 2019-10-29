package step2.race.controller;

import step2.car.domain.Status;
import step2.race.domain.Race;
import step2.race.domain.RaceHistory;
import step2.race.domain.RaceResult;

import java.util.List;

public class OutputView {
    private static final String POSITION = "-";
    private static final String DELIMITER = " : ";

    public void showResult(Race race) {
        List<RaceHistory> raceHistories = race.getRaceHistories();
        RaceResult raceResult = race.getResult();

        showProgress(raceHistories);
        showWinner(raceResult);
    }


    private void showProgress(List<RaceHistory> raceHistories) {
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
        StringBuilder carPosition = new StringBuilder(status.getName() + DELIMITER);
        for (int i = 0; i < status.getPosition(); i++) {
            carPosition.append(POSITION);
        }
        System.out.println(carPosition.toString());
    }

    private void showWinner(RaceResult raceResult) {
        String winnersNames = String.join(", ", raceResult.getWinnersNames());
        System.out.println(String.format("%s가 최종 우승했습니다.", winnersNames));
    }

}
