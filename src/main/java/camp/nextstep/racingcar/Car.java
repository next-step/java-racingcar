package camp.nextstep.racingcar;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int givenNumber) {
        if (givenNumber > 4) {
            return;
        }
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
