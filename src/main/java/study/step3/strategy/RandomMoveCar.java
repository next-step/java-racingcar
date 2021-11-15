package study.step3.strategy;

import java.util.Random;

public class RandomMoveCar implements MoveCar {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MIN_FORWARD_NUMBER = 4;
    private int extractNumber;

    public RandomMoveCar() {
        Random random = new Random();
        this.extractNumber = random.nextInt(MAX_RANDOM_NUMBER);
    }

    private int getExtractNumber(){
        return this.extractNumber;
    }

    /**
     * 차량 이동을 위한 시도 숫자 조회
     * @return
     */
    @Override
    public boolean isMove() {
        return getExtractNumber() >= MIN_FORWARD_NUMBER;
    }

}
