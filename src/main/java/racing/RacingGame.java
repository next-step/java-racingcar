package racing;

public class RacingGame {
    private static final String RESULT_MESSAGE = "실행결과";

    public void start() {
        int carCount = RacingInput.input(RacingInputType.CAR);
        int tryCount = RacingInput.input(RacingInputType.TRY);
        Racers racers = new Racers(carCount);

        System.out.println(RESULT_MESSAGE);
        race(racers, tryCount);
    }

    private void race(Racers racers, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racers.moveAll();
        }
    }
}
