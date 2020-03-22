package study.racingcar;

public class RacingGame {
    private int time;
    private int[] carPositions;
    private MovableDistance movableDistance;

    public RacingGame(RacingGameVo racingGameVo,
                      MovableDistance movableDistance) {
        carPositions = new int[racingGameVo.getNumberOfCar()];
        this.time = racingGameVo.getTime();
        this.movableDistance = movableDistance;
    }

    public int[] move() {
        if (!isMovable()) {
            return carPositions;
        }
        time--;

        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += movableDistance.getDistance();
        }

        return carPositions;
    }

    public boolean isMovable() {
        return time != 0;
    }
}
