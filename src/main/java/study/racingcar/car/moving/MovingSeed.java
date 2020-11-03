package study.racingcar.car.moving;

public class MovingSeed {

    int seed;

    private MovingSeed(int seed) {
        this.seed = seed;
    }

    public static MovingSeed newSeed(int seed) {
        return new MovingSeed(seed);
    }

    public boolean isMovable() {
        return seed >= 4;
    }
}
