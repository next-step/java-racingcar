package step3.model;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    public static final int LIMIT = 4;
    public static int randomNumber;

    /**
     * 랜덤 숫자를 기준으로 움직일수 있는지 판단해서 자동차를 움직인다.
     */
    @Override
    public boolean canMove() {
        randomNumber = generateRandomNumbers();
        return randomNumber >= LIMIT;
    }

    /**
     * 0~9 범위 랜덤숫자 발생
     * @return
     */
    public int generateRandomNumbers() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public int getRandomNumber(){
        return randomNumber;
    }
}
