package car.domain;

public final class CarName {

    private String name;
    private final int CAR_NAME_LENGTH_LOWER_BOUND = 5;

    CarName(String name) {
        validateCarName(name);
        this.name = name.trim();
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LOWER_BOUND) {
            throw new RuntimeException("자동자 이름의 최소값보다 작습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
