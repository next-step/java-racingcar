package racingcar.model;

public class Car{

    public static final int RUNNING_CONDITION = 4;
    private Position position;
    private String name;

    Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        NameValidator.validate(name);
        return new Car(name, Position.create());
    }

    public Position move(int power) {
        if(isRunning(power)){
            this.position = position.incrementExact();
        }
        return position;
    }

    private boolean isRunning(int power) {
        return RUNNING_CONDITION <= power;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position + ", name=" + name + '}';
    }
}