package racingcar.domain;

class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;
    private final String name;
    private int position;

    public Car(final String name) {
        this(name, DEFAULT_POSITION); // 생성자 체이닝
    }

    public Car(final String name, final int position) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final int condition) {
        if (condition >= 4) {
            position++;
        }
    }
}
