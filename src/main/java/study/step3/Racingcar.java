package study.step3;

public class Racingcar {
    private int position;
    private RandomNumber randomNumber = new RandomNumber();

    public int getPosition() {
        return position;
    }

    public void tryToMoveForward() {
        if (4 <= randomNumber.generateRandomNumber()) {
            position++;
        }
    }
}
