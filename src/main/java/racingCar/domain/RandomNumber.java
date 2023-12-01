package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    public static final int RANDOM_LIMIT_VALUE = 10;

    public List<Integer> generateRandomNumber(int carNum) {
        List<Integer> numberList = new ArrayList<>( );
        for(int i = 0; i < carNum; i++) {
            numberList.add(new Random().nextInt(RANDOM_LIMIT_VALUE));
        }

        return numberList;
    }
}
