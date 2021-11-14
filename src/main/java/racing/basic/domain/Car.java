package racing.basic.domain;

public class Car {

    private int roadLength;

    protected void moveOrStop(int percentage) {
        if(4 <= percentage) {
            roadLength += 1;
        }
    }

    public int toInteger() {
        return roadLength;
    }
}
