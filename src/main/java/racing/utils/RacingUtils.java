package racing.utils;

import java.util.Random;

public class RacingUtils {

    public static final int RANDOM_NUMBER_RULE = 4;
    public static final int RANDOM_NUMBER_LIMIT = 10;


    public static int randomNumber(){
        return new Random().nextInt(RANDOM_NUMBER_LIMIT);
    }

    public static boolean compareNumbers(int number){
        if(number < RANDOM_NUMBER_RULE){
            return false;
        }
        return true;
    }

}
