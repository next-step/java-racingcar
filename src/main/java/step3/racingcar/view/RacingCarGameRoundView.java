package step3.racingcar.view;

import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarGameRound;

public class RacingCarGameRoundView {

    private final RacingCarGameRound gameRound;

    public RacingCarGameRoundView(RacingCarGameRound gameRound) {
        this.gameRound = gameRound;
    }

    public void showRound() {
        System.out.println();
        System.out.println("Round #" + this.gameRound.no());
        for (RacingCar car : this.gameRound.cars()) {
            RacingCarView carView = new RacingCarView(car);
            carView.showCar();
        }
    }

}
