package step4;

public class RandomNumber {

    private static final int MOVABLE_BOUNDARY = 3;
    private static int randomNumber;

    public RandomNumber() {
        this.randomNumber = new java.util.Random().nextInt(10);
    }

    boolean isRandomNumberGreaterThanThree() {
        return this.randomNumber > MOVABLE_BOUNDARY;
    }
}
