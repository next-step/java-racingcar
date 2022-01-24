package racingcar;

public class Car {

    String name;
    int position;
    final int INIT_POSITION = 0;

    Car() {
        this.name = "";
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
