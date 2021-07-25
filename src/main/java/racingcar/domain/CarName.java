package racingcar.domain;

public class CarName {
    private String name;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
