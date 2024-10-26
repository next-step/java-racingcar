package step4.view;

import step4.domain.RacingCar;

public class ConsoleOutputView implements OutputView {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void startAndPrintRacing(RacingCar racingCar) {
        int raceCount = 0;
        while (racingCar.compareNumberOfRace(raceCount) > 0) {
            racingCar.doRacing();

            RacingCarResultView.printRacingCarStatus(this, racingCar);
        }
        RacingCarResultView.printRacingCarWinner(this, racingCar);
    }
}
