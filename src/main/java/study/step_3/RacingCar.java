package study.step_3;

public class RacingCar {

    private final static int condition = 4;
    private int distance;

    public void move() {
        int randomNumber = getRandomNumber();

        if (this.canMove(randomNumber)) {
            distance++;
        }
    }

    private int getRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.generate();
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= condition;
    }

    public int getDistance() {
        return distance;
    }
}
