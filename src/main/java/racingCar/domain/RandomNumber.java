package racingCar.domain;

public class RandomNumber {
    public static final int ROUNDUP_NUMBER = 10;

    public static int createRandomNumber() {
        return (int) (Math.random() * ROUNDUP_NUMBER);
    }

}
