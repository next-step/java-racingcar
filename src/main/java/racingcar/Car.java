package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        position = 0;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
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