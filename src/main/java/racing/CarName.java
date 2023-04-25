package racing;

public class CarName {
    private final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String carName) {
        validateNameLength(carName);
        name = carName;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName(){
        return name;
    }

}
