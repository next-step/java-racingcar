package step3;

import step3.service.CarsDto;
import step3.service.Racing;
import step3.view.RacingInputView;

public class RacingGamePlayer {

    public void playRacingGame() {
        final int carCount = RacingInputView.carCount();
        final int tryCount = RacingInputView.tryCount();

        final Racing racing = randomMovementRacing(carCount, tryCount);


    }

    private Racing randomMovementRacing(int carCount, int tryCount) {
        final CarsDto cars = CarsDto.randomStrategyCars(carCount);

        return Racing.of(cars, tryCount);
    }

    public static void main(String[] args) {
        final RacingGamePlayer racingGamePlayer = new RacingGamePlayer();

        racingGamePlayer.playRacingGame();
    }

}
