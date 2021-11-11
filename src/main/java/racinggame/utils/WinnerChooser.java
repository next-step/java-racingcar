package racinggame.utils;

import racinggame.vo.CarState;
import racinggame.vo.MoveResult;
import racinggame.vo.Winners;
import racinggame.exception.NotInstanceException;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerChooser {
    private static final int INDEX_CORRECT_ADJUSTMENT_NUMBER = 1;
    private static final int NOT_FOUNT_MAX = 0;

    private WinnerChooser() {
        throw new NotInstanceException();
    }

    public static Winners chooseWinner(List<MoveResult> moveResults) {
        return new Winners(extractWinner(moveResults));
    }

    private static List<String> extractWinner(List<MoveResult> moveResults) {
        MoveResult moveResult = getFinalMoveResult(moveResults);
        int maxPosition = getMaxPosition(moveResult.getResults());

        return moveResult.getResults()
                .stream()
                .filter(carState -> carState.currentPosition() == maxPosition)
                .map(CarState::assignName)
                .collect(Collectors.toList());
    }

    private static MoveResult getFinalMoveResult(List<MoveResult> moveResults) {
        return moveResults.get(moveResults.size() - INDEX_CORRECT_ADJUSTMENT_NUMBER);
    }

    private static int getMaxPosition(List<CarState> carStates) {
        return carStates.stream()
                .mapToInt(CarState::currentPosition)
                .max()
                .orElse(NOT_FOUNT_MAX);
    }
}
