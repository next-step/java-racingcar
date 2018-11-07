package racingcar.domain;

public class Car {

    private static final int MOVABLE_POSITION = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    // TEST를 위해 필요함.
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int move(int randomNumber) {
        if(randomNumber >= MOVABLE_POSITION) {
            position += 1;
        }

        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
