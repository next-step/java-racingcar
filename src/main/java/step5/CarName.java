package step5;

public class CarName {

    private String name;

    public CarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 널이나 공백이 들어올 수 없습니다.");
        }
        this.name = carName;
    }

    public String getName() {
        return name;
    }
}
