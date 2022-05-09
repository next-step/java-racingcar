package racingcarwinnerrefactor;
import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.TryCount;
import racingcarwinnerrefactor.util.GameController;

public class RacingCarGame {

    public static void main(String[] args) {

        ParticipatedCars participatedCars = ParticipatedCars.participatedCarsFactory();
        TryCount tryCount = TryCount.tryCountFactory();

        GameController gameController = GameController.gameControllerFactory(tryCount, participatedCars);

        gameController.play();
    }
}
