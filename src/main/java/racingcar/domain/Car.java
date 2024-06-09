package racingcar.domain;

public class Car {
    private int position;

    public int getPosition() { return position; }

    public String getName() { return name; }

    private final String name;
    public Car(String name) {
        this(0, name);
    }
    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }
    public void move(int moveValue){
        position += moveValue;
    }


    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
