package race.domain;

public class Car {

    private int position;
    private final String name;

    public Car(int position, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("공백없이 정확한 이름을 입력해주세요.");
        }

        if (position < 0) {
            throw new IllegalArgumentException(String.format("(%s)은 음수입니다. 차의 위치(position)는 0이상의 양의 정수만 허용됩니다.", position));
        }

        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public void go() {
        this.position++;
    }

}
