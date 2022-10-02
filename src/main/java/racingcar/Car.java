package racingcar;

public class Car {

    private int location;

    public int getLocation() {
        return location;
    }

    public void nextTurn(Generator generator) {
        if (generator.nextValue() >= 4) {
            location++;
        }
    }
}
