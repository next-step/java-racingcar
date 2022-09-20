package step3.domain;

public class Car {
    private int state = 0;

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.randomNumber() >= 4) {
            state++;
        }
    }

    public int state() {
        return state;
    }
}
