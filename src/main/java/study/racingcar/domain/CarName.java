package study.racingcar.domain;

public class CarName {

    private static final int LENGTH_LIMIT = 5;

    private String name;

    public CarName(String name) {
        if (name.replaceAll(" ", "").isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다");
        }
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다");
        }
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }
}
