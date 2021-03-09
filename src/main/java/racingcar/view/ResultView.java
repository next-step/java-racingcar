package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    private static final String HYPHEN = "-";

    public void printExecutionResult(String carName,int position) {
        StringBuilder hyphens = new StringBuilder();
        hyphens.append(carName + " : ");
        for (int i = 0; i<position; i++) {
            hyphens.append(HYPHEN);
        }
        System.out.println(hyphens);
    }

    public void printLiterallyExecutionResult() {
        System.out.println("실행 결과");
    }

    public void drawWinner(List<String> winnerCarNameList) {
        StringJoiner winners = new StringJoiner(",");
        for (String winnerCarName : winnerCarNameList) {
            winners.add(winnerCarName);
        }
        System.out.println(winners.toString() + "가 우승했습니다.");
    }
}
