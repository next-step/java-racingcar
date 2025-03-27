package racingcar.participant;

public class CarName {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d자 이하여야 합니다.", MAX_NAME_LENGTH));
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CarName carName = (CarName) o;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
