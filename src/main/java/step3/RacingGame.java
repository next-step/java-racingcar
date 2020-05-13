package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public int[] move(){

        int[] result = new int[carPositions.length];

        for (int i = 0; i < carPositions.length; i++) {
            int randomNum = getRandomNum();

            result[i] = randomNum >= 4 ? carPositions[i] + 1 : carPositions[i];
        }

        carPositions = result;

        return result;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<int[]> getResult(){

        List<int[]> carPositionList = new ArrayList<>();

        for (int i = 0; i < time; i++) {
            carPositionList.add(move());
        }

        return carPositionList;
    }

    public void setInputValues(int numberOfCars, int moveCount) {
        validationCheck(numberOfCars, moveCount);
        this.carPositions = new int[numberOfCars];
        this.time = moveCount;
    }

    private void validationCheck(int numberOfCars, int moveCount) {
        if (numberOfCars < 0) {
            throw new IllegalArgumentException("자동차 대수는 음수를 입력할 수 없습니다.");
        }

        if (moveCount < 0) {
            throw new IllegalArgumentException("시도 회수는 음수를 입력할 수 없습니다.");
        }
    }
}
