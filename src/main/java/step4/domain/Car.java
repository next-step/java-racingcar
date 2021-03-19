package step4.domain;

public class Car {
    private static final int INITIAL_POSITION_NUM = 0;
    private static final int FORWARD_NUM = 4;

    private final Name name;
    private int position;

    private Car(final String name) {
        this(new Name(name), INITIAL_POSITION_NUM);
    }

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public void move(int randomNum) {
        if (randomNum >= FORWARD_NUM) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
