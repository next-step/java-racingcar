package racing;

public class RacingGame {

    public void start() {
        int carCount = RacingInput.input(RacingInputType.CAR);
        int tryCount = RacingInput.input(RacingInputType.TRY);
        Racers racers = new Racers(carCount);

        System.out.println("실행결과");
        race(racers, tryCount);
    }

    private void race(Racers racers, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racers.moveAll();
        }
    }
}
