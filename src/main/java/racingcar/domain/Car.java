package racingcar.domain;

class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Car(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
