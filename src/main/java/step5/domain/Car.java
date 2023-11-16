package step5.domain;

public class Car {
    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car defaultOf(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 알맞지 않습니다.");
        }
        return new Car(name);
    }
}
