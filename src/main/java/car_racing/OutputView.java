package car_racing;

import java.util.List;

public class OutputView {

    private static final String OUT_MESSAGE_GAME_ENDS = "\n--게임이 끝났습니다.--\n";
    private static final String OUT_MESSAGE_CAR_RACING_RESULT = "실행 결과";
    private static final String CAR_MOVE_SIGNAL = "-";
    private static final String ONE_ROUND_ENDS_SIGNAL = "\n";

    public void showCarRacingGameOutput(CarRacingResult carRacingResult) {
        System.out.println(OUT_MESSAGE_GAME_ENDS);
        System.out.println(OUT_MESSAGE_CAR_RACING_RESULT);

        List<List<Integer>> racingResult = carRacingResult.getRacingResult();
        StringBuilder result = new StringBuilder();

        // TODO: 3중 for 문 개선
        for (List<Integer> eachRoundResult : racingResult) {
            result.append(buildEachRoundResult(eachRoundResult));
            result.append(ONE_ROUND_ENDS_SIGNAL);
        }

        System.out.println(result.toString());
    }

    public StringBuilder buildEachRoundResult(List<Integer> eachRoundResult) {
        StringBuilder result = new StringBuilder();

        for (Integer eachRoundCarPosition : eachRoundResult) {
            result.append(buildEachCarResult(eachRoundCarPosition));
            result.append(ONE_ROUND_ENDS_SIGNAL);
        }

        return result;
    }

    public StringBuilder buildEachCarResult(Integer carPosition) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < carPosition; i++) {
            result.append(CAR_MOVE_SIGNAL);
        }

        return result;
    }
}
