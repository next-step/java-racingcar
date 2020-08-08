package racingcar;

public class RacingCar extends RacingVehicle {
    private static final int FIRST_ATTEMPT = 0;

    public void race(int attemptNumber) {
        for (int attempt = 0; attempt < attemptNumber; attempt++) {
            move(attempt);
        }
    }

    private void move(int attempt) {
        int move = (attempt == FIRST_ATTEMPT)
                ? 0
                : raceRecord.getBy(attempt - 1);

        if (movable()) {
            move += 1;
        }

        raceRecord.add(move);
    }

}
