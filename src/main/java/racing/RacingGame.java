package racing;

import java.util.Random;

public class RacingGame implements RandomValue{
    private static final int NUMBER_OF_MOVEMENT_POSSIBLE = 4;
    private static final int NUMBER_OF_RANDOM_RANGE = 10;
    private RacingVO racingVO;
    private Random rand = new Random();


    public RacingGame(RacingVO racingVO) {
        this.racingVO = racingVO;
    }

    public int[] move() {
        int[] carPositions = racingVO.getCarPositions();

        for(int j = 0; j < carPositions.length; ++j) {
            if (isMovable(getRandomValue())) {
                carPositions[j]++;
            }
        }

        return carPositions;
    }

    public boolean isMovable(int randomValue) {
        boolean isMove = false;

        if (randomValue >= NUMBER_OF_MOVEMENT_POSSIBLE) {
            isMove = true;
        }
        return isMove;
    }


    @Override
    public int getRandomValue() {
        return rand.nextInt(NUMBER_OF_RANDOM_RANGE);
    }

}