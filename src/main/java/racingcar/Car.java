package racingcar;

public class Car {

    private int position = 0;

    public void action(int num) {
        Command.of(num).accept(this);
    }

    public void forward() {
        this.position++;
    }

    public void nonForward() {
        // Non Forward
    }
}
