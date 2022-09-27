package game.domain;

public class Car {

    private int location;

    public int location() {
        return location;
    }

    public void forward(int number) {
        location += number;
    }

}
