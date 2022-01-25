package racingcar;

public class Car {

    final int INIT_POSITION = 0;
    String name;
    int position;

    Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void go() {
        this.position++;
    }
}
