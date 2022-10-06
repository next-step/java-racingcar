package racing_car_with_winner.view;

import racing_car_with_winner.model.CarName;
import racing_car_with_winner.model.MoveResult;

public class MoveResultView {
    private static final String MOVE = "-";
    private static final String SHOW_MOVE_RESULT_TEMPLATE = "%s : %s\n";
    private final String message;

    public MoveResultView(CarName carName, MoveResult moveResult) {
        this.message = String.format(SHOW_MOVE_RESULT_TEMPLATE, carName.getValue(), convertMoveResultToView(moveResult.getMoveCount()));
    }

    private String convertMoveResultToView(int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            stringBuilder.append(MOVE);
        }

        return stringBuilder.toString();
    }

    public String getMessage() {
        return message;
    }
}
