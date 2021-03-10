package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String winners = winnerCarNameList.stream()
                .collect(Collectors.joining(","));

        System.out.println(winners + "가 우승했습니다.");
    }


}
