package car.domain;

public final class CarName {

    private final String name;
    private final static int CAR_NAME_LENGTH_LOWER_BOUND = 5;

    CarName(final String name) {
        validateCarName(name);
        this.name = name.trim();
    }

    private void validateCarName(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException("자동자 이름의 길이가 하한선 보다 작습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
