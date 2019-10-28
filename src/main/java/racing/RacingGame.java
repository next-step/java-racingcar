package racing;

public class RacingGame {
    public void start() {
        int carCount = RacingInput.input(RacingInputType.CAR);
        int tryCount = RacingInput.input(RacingInputType.TRY);
        Racers racers = new Racers(carCount);

        RacingOutput.printResultMessage();
        race(racers, tryCount);
    }

    private void race(Racers racers, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racers.moveAll();
            RacingOutput.printCurrentStatus(racers);
        }
    }
}
