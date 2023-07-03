package racing.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return this.name;
    }
    public int getPosition() {
        return this.position;
    }

    public void moveOrStop(int value) {
        if (value >= 4) {
            this.position++;
        }
    }

}
