package racingcar.race;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    private static int sequence = 0;

    private final String name;
    private final int id;
    private int distance;

    public Car() {
        this(null);
    }

    public Car(String name) {
        validationName(name);
        this.name = name;
        this.id = newSequence();
        this.distance = 0;
    }

    private void validationName(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(" 자동차 이름은 5자를 초과할 수 없습니다. - " + name);
        }
    }

    public String name() {
        return name;
    }

    private int newSequence() {
        return ++sequence;
    }

    public int id() {
        return id;
    }

    public int distance() {
        return distance;
    }

    public void move() {
        ++distance;
    }
}
