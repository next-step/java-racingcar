package racingcar.presentation;

import racingcar.business.Racing;

import java.util.List;
import java.util.Map;

public class ResultView {

    private final Racing.Recording recordingData;

    public ResultView(final Racing racing) {
        this.recordingData = racing.getRecordingData();
    }

    public void printRacingResult() {
        List<Map<String, Integer>> racingHistory = recordingData.getRacingHistory();

        System.out.println("\n실행 결과");
        racingHistory.forEach(history -> {
            printHistory(history);
            System.out.println();
        });

        int finalHistoryIndex = racingHistory.size() - 1;
        Map<String, Integer> finalHistory = racingHistory.get(finalHistoryIndex);
        printWinner(finalHistory);
    }

    private void printHistory(Map<String, Integer> history) {
        history.keySet().forEach(carName -> {
            int distance = history.get(carName);
            printDistance(carName, distance);
        });
    }

    private void printDistance(String carName, int distance) {
        StringBuilder distanceIndicator = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceIndicator.append("-");
        }
        System.out.println(carName + " : " + distanceIndicator);
    }

    private void printWinner(Map<String, Integer> finalHistory) {
        StringBuilder winner = new StringBuilder();
        int maxDistance = 0;

        for (Map.Entry car : finalHistory.entrySet()) {

            int distance = (int) car.getValue();
            String carName = (String) car.getKey();

            if (maxDistance == distance) {
                winner.append(", ").append(carName);
            }

            if (maxDistance < distance) {
                maxDistance = distance;
                winner = new StringBuilder();
                winner.append(carName);
            }

        }

        if (winner.indexOf(", ") == 0) {
            winner = winner.replace(0, 0, "");
        }

        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
