package racingCar;


public class RandomNumber {
    public static final int ROUNDUP_NUMBER = 10;
    public static final int RANDOM_MINIMUM = 0;
    public static final int RANDOM_MAXIMUM = 9;

    public int createRandomNumber(){
        return (int) (Math.random()*ROUNDUP_NUMBER);

    }

    public boolean validateRandomNumber(int randomNumber) {
        return RANDOM_MINIMUM<=randomNumber && randomNumber <=RANDOM_MAXIMUM;
    }
}
