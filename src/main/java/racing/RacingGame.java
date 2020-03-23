package racing;

import java.util.Random;

public class RacingGame {
    RacingVO racingVO;

    public RacingGame(RacingVO racingVO) {
        this.racingVO = racingVO;
    }

    public int[] move() {
        int[] carPositions = racingVO.getCarPositions();

        for(int j = 0; j < carPositions.length; ++j) {
            Random rand = new Random();
            int randomValue = rand.nextInt(10);
            if (isMovable(randomValue)) {
                carPositions[j]++;
            }
        }

        racingVO.setCarPositions(carPositions);
        return carPositions;
    }

    public boolean isMovable(int randomValue) {
        boolean isMove = false;
        if (randomValue >= 4) {
            isMove = true;
        }

        return isMove;
    }
}