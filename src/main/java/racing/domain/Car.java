package racing.domain;

public class Car {
    private int position;
    private Name name;

    public Car(String name) {
        this.position = 0;
        this.name = new Name(name);
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public Name getName() {
        return this.name;
    }
}
