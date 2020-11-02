package study.step3;

import java.util.Objects;
import java.util.Random;

public class RealCar implements Car {
    private final String name;
    private boolean moved;
    private final Random random;
    private final Long id;

    public RealCar(String name) {
        this.name = name;
        this.random = new Random();
        this.id = random.nextLong();
    }

    @Override
    public boolean isMoved() {
        return moved;
    }

    @Override
    public void move() {
        moved = guessMove();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    private boolean guessMove() {
        return random.nextInt(10) >= 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealCar realCar = (RealCar) o;
        return name.equals(realCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
