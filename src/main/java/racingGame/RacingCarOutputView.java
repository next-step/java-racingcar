package racingGame;

import java.util.List;
import java.util.Map;

public class RacingCarOutputView {
    public void printGame(List<Map<String, Integer>> gameStates, List<String> winners) {
        printGameStart();
        for (Map<String, Integer> state : gameStates) {
            printGameState(state);
        }
        printWinners(winners);
    }

    private void printGameStart() {
        System.out.println("실행 결과");
    }

    private void printGameState(Map<String, Integer> state) {
        for (Map.Entry<String, Integer> entry : state.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            System.out.println(carName + " : " + "-".repeat(position));
        }
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }


}