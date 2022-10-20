package racingCar;

import java.util.Objects;

public class RacingCar {
    private int numberOfMovement = 0;

    private String name;


    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int numOfMovement) {
        validateName(name);
        this.name = name;
        this.numberOfMovement = numOfMovement;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void tryMove(final int randomNumber) {
        if (canMove(randomNumber)) {
            numberOfMovement++;
        }
    }

    public int getNumberOfMovement() {
        return this.numberOfMovement;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingCar racingCar = (RacingCar) o;
        return numberOfMovement == racingCar.numberOfMovement && name.equals(racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfMovement, name);
    }

    public boolean isFurtherAsMuchAs(int movements) {
        return this.numberOfMovement == movements;
    }

    public boolean canMove(int randomNumber) {
        return 4 <= randomNumber;
    }

    public String toString() {
        return this.name + " : " + trace();
    }

    public String name() { return this.name; }

    private String trace() {
        String trace = "";
        for (int i = 0; i < this.numberOfMovement ; i++) {
            trace += "-";
        }

        return trace;
    }
}
