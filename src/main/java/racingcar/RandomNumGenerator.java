package racingcar;

import java.util.Random;

public class RandomNumGenerator {
    //TODO 랜덤넘버 생성에 대한 테스트 추가 (지금은 방법을 모르겠다 또륵)
    private final static int MAX_RANDOM_NUMBER = 9;
    public int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }
}
