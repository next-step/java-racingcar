package racingGame.view;

import racingGame.Position;
import racingGame.Positions;

import java.util.List;

public class ResultView {

    private static final String START_TEXT = "실행 결과\n";
    private static final String ENTER = "\n";
    private static final String POSITION_TEXT = "-";

    private StringBuilder resultMessage = new StringBuilder(START_TEXT);


    public ResultView(List<Positions> result) {
        result.forEach(this::addPosition);
    }

    private void addPosition(Positions positions) {
        positions.getValue()
                .forEach(position -> resultMessage
                        .append(translatePositionText(position))
                        .append(ENTER));
        resultMessage.append(ENTER);
    }

    private String translatePositionText(Position position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position.getValue(); i++) {
            builder.append(POSITION_TEXT);
        }
        return builder.toString();
    }

    public void print() {
        System.out.println(resultMessage.toString());
    }
}

