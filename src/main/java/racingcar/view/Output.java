package racingcar.view;

import racingcar.dto.MoveResult;
import racingcar.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public void showCarCountInputRequestMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void showTryCountInputRequestMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void showResult(int carCount, RaceResult result) {

        List<String> messages = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            messages.add("");
        }

        System.out.println("<<실행결과>>");
        for (MoveResult moveResult : result.getMoveLogs() ){
            setMoveLogMessage(messages, moveResult);

            showCurrentTurnMoveLog(messages);
            System.out.println("\n");
        }

    }

    private static void setMoveLogMessage(List<String> messages, MoveResult moveResult) {
        List<Boolean> moveLogs = moveResult.getMoveLogs();
        for (int i = 0; i < moveLogs.size(); i++) {
            if (moveLogs.get(i)) {
                String before = messages.get(i);
                messages.set(i, before.concat("-"));
            }
        }
    }

    private static void showCurrentTurnMoveLog(List<String> messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}
