package racingcar.model;

public class CarName {
    private final String name;

    public CarName(String name) {
        checkCarName(name);
        this.name = name;
    }

    private void checkCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름이 5자 초과합니다");
        }
    }

    public String getName() {
        return name;
    }
    
}
