package step5.domain;
import java.util.Objects;

public class Car {

    private static final int WORD_MAX_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(final String name) {
        maxLengthException(name);
        this.name = name;
        this.position = 0;
    }

    /* 테스트 위한 코드 */
    public Car(final String name, int position) {
        maxLengthException(name);
        this.name = name;
        this.position = position;
    }

    public void move(GenerateNumber generateNumber) {
        if (generateNumber.generateRandom() >= 4) {
            this.position++;
        }
    }

    private void maxLengthException(String name) {
        if (isExceedWord(name)) {
            throw new IllegalArgumentException("5글자 초과 입력하실 수 없습니다.");
        }
    }

    public boolean isExceedWord(String name) {
        if (name.length() > WORD_MAX_LENGTH) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
