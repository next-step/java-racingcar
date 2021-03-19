package step4.domain;

public class Car {
    private static final int INITIAL_POSITION_NUM = 0;
    private static final int FORWARD_NUM = 4;
    private static final String POSITION_CHARACTER = "-";

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

    private String getPositionString(final int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_CHARACTER);
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", getName(), getPositionString(position));
    }
}
