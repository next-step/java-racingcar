package racingcarrefectoring.model;

public class Judge {

    private static final int REFERENCE_VALUE = 4;

    public static void moveOrStop(Car car){
       if(isAndAbove(RandomGenerator.getRandomNumber())){
           car.move();
       }
    }

    private static boolean isAndAbove(int value){
        return value >= REFERENCE_VALUE;
    }
}
