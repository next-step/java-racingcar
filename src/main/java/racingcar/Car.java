package racingcar;

public class Car {

    public static final int SET_POSITION = 1;
    public static final int NAME_MAX_LENGTH = 5;

    private Integer position;
    private String name;

    public Car() {
        this(SET_POSITION);
    }

    public Car(String name) {
        this(SET_POSITION);
        this.name = ValidatedName(name);
    }

    private String ValidatedName(String name) {
        if (isBlank(name)) {
            throw new RuntimeException("빈 문자열은 자동차 이름으로 지정할 수 없습니다.");
        }
        if (isExceedMaxLength(name)) {
            throw new RuntimeException("자동차 이름은 5글자를 넘길 수 없습니다.");
        }
        return name;
    }

    private boolean isExceedMaxLength(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    protected Car(int position) {
        this.position = position;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    public Car clone() {
        return new Car(this.position);
    }

}
