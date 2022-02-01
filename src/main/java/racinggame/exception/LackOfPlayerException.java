package racinggame.exception;

import java.util.List;
import racinggame.domain.RacingCar;

public class LackOfPlayerException extends IllegalArgumentException {

    public static final int MINIMUM_PLAYER = 2;
    private static final String MESSAGE = String.format("게임을 시작하려면 %d명 이상의 참가자가 필요합니다.",
            MINIMUM_PLAYER);

    public LackOfPlayerException(List<RacingCar> racingCars) {
        super(MESSAGE + " (현재 참여인원: " + racingCars.size() + ")");
    }
}
