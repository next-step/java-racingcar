package racingcar;

public class Car {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

    public void moveCarByRandomNumber(int difficulty, int randomNumber) {
        if(randomNumber >= difficulty) {
            go();
        }
    }
}