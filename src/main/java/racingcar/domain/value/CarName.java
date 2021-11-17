package racingcar.domain.value;

public class CarName {

    private final String name;

    private CarName(String name) {

        if(name.length() > 5 ) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다!!!");
        }

        this.name = name;
    }

    public static CarName create(String name) {

        return new CarName(name);
    }

    public String getName() {

        return name;
    }
}
