package racing;

public class RacingGame {
    public void start() {
        String racerNames = RacingInput.inputString(RacingInputType.CAR);
        int tryCount = RacingInput.inputInt(RacingInputType.TRY);
        Racers racers = new Racers(racerNames);

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
