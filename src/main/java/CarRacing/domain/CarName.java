package CarRacing.domain;

public class CarName {
    private static final int LIMIT_LENGTH_OF_CAR_NAME = 5;

    private String name;

    public CarName(String name) {
        validateName(name);
        setName(name);
    }

    public String Name() {
        return this.name;
    }

    private void validateName(String inputName) {
        if (inputName == null || inputName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (inputName.length() > LIMIT_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("이름은 " + LIMIT_LENGTH_OF_CAR_NAME + "자 이하만 가능합니다. [입력값: " + inputName + "]");
        }
    }

    private void setName(String inputName) {
        this.name = inputName.trim();
    }
}
