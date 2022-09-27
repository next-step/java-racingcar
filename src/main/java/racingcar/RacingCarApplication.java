package racingcar;

import java.io.IOException;

public class RacingCarApplication {
    public static void main(String[] args) throws IOException {
        int carCount = InputView.carCountScan();
        int round = InputView.roundScan();

        Race race = new Race(carCount);
        ResultView.printStartMessage();
        for (int i = 0; i < round; i++) {
            ResultView.print(race.playRace());
        }
    }
}
