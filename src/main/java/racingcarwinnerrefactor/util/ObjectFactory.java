package racingcarwinnerrefactor.util;

import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.TryCount;
import racingcarwinnerrefactor.domain.WinnerCars;
import racingcarwinnerrefactor.view.InputView;

public class ObjectFactory {
    private static ParticipatedCars participatedCars;
    private static TryCount tryCount;
    private static GameUtil gameUtil;
    private static WinnerCars winnerCars;

    public static ParticipatedCars createParticipatedCars() {
        String names = InputView.inputCarNames();
        if(participatedCars == null)    participatedCars = new ParticipatedCars(names);
        return participatedCars;
    }

    public static TryCount createTryCount() {
        int count = InputView.inputTryCount();
        if(tryCount == null)    tryCount = new TryCount(count);
        return tryCount;
    }

    public static GameUtil createGameUtil() {
        if(gameUtil == null)    gameUtil = new GameUtil(tryCount, participatedCars);
        return gameUtil;
    }

    public static WinnerCars winnerCars() {
        if(winnerCars == null)  winnerCars = new WinnerCars(participatedCars);
        return winnerCars;
    }
}
