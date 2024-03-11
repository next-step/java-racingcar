package racingcar;

public final class RacingCarApplication {

    private RacingCarApplication() {
    }

    public static void main(String[] args) {
        final int carCount = 5;
        final int playingCount = 3;

        Racing.race(carCount, playingCount);
    }
}
