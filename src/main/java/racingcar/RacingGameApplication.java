package racingcar;

import racingcar.view.RacingCarView;
import racingcar.view.RacingGameInputView;

import java.util.*;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames = RacingGameInputView.inputCarNumber();
        int moveNumber = RacingGameInputView.inputMoveNumber();
        RacingCarView.printMessage();
        RacingStadium racingStadium = new RacingStadium(carNames);
        racingStadium.race(moveNumber);
        racingStadium.matchResult();
        racingStadium.awards();
    }
}
