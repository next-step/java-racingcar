package racingcar.presentation;

import racingcar.business.Racing;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printRacingResult(Racing racing) {
        Racing.Recording recordingData = racing.getRecordingData();
        List<Map<String, Integer>> racingHistory = recordingData.getRacingHistory();

        System.out.println("\n실행 결과");
        racingHistory.forEach(history -> {
            history.keySet().forEach(carName -> printDistance(history, carName));
            System.out.println();
        });
    }

    private void printDistance(Map<String, Integer> history, String carName) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < history.get(carName); i++) {
            distance.append("-");
        }
        System.out.println(distance);
    }
}
