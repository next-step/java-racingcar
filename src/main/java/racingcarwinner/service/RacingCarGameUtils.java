package racingcarwinner.service;

import racingcarwinner.domain.CarCount;
import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.domain.WinnerCars;
import racingcarwinner.strategy.RandomMoveStrategy;
import racingcarwinner.view.OutputView;

public class RacingCarGameUtils {
    private CarCount carCount;
    private TryCount tryCount;
    private OutputView outputView;

    public RacingCarGameUtils(CarCount carCount, TryCount tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        outputView = new OutputView();
    }

    public void play(ParticipatedCars participatedCars) {
        for(int i = 0; i < tryCount.getTryCount(); i++) {
            participatedCars.getParticipatedCars().stream().forEach(car ->  car.move(new RandomMoveStrategy()));
            outputView.printGameResult(participatedCars);
        }

        WinnerCars winnerCars = new WinnerCars(participatedCars);
        System.out.println(winnerCars.getWinnerCars());
        outputView.printWinnerResult(winnerCars);
    }




}
