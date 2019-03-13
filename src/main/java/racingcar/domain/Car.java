package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int addPosition() {
        return ++this.position;
    }

    public Boolean equalsPosition(int position) {
        return this.position == position;
    }
}
