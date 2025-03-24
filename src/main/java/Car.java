public class Car {

    private final String name;

    public Car(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
    }
}
