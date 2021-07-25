package racing.utils;

import java.util.Random;

public class RacingUtils {

    public static final int RANDOM_NUMBER_RULE = 4;
    public static final int RANDOM_NUMBER_LIMIT = 10;
    public static final int INPUT_VALUE_RULE = 0;
    private static final Random RANDOM_NUMBER = new Random();

    public static int randomNumber(){
        return RANDOM_NUMBER.nextInt(RANDOM_NUMBER_LIMIT);
    }

    public static boolean compareNumbers(int number){
        return number >= RANDOM_NUMBER_RULE;
    }

    public static void checkInputValue(int round, int car){
        if(round <= INPUT_VALUE_RULE){
            throw new IllegalArgumentException("경주 횟수는 0 이상으로 입력되어야합니다.");
        }
        if(car <= INPUT_VALUE_RULE){
            throw new IllegalArgumentException("경주 횟수는 0 이상으로 입력되어야합니다.");
        }
    }


}
