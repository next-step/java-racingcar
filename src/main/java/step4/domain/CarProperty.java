package step4.domain;

public class CarProperty {

    private static final int INITIAL_STEP = 0;

    private final String name;
    private final int step;

    public CarProperty(String name) {
        validateNameLength(name);
        this.name = name;
        this.step = INITIAL_STEP;
    }

    public CarProperty(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public void validateNameLength(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getStep() {
        return this.step;
    }

    public String getName() {
        return this.name;
    }
}
