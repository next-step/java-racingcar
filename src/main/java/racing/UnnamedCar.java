package racing;

import java.util.Objects;

class UnnamedCar implements Racer {
    private static final String MARK = "-";

    private String position;

    private UnnamedCar(String position) {
        this.position = position;
    }

    public static UnnamedCar from(String position) {
        Objects.requireNonNull(position);
        return new UnnamedCar(position);
    }

    public static UnnamedCar emptyCar() {
        return new UnnamedCar("");
    }

    @Override
    public UnnamedCar go() {
        this.position += MARK;
        return this;
    }

    @Override
    public String position() {
        return position;
    }
}
