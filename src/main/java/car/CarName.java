package car;

public class CarName {
    
    private final String name;

    public CarName(String name) {
        if (name.length() >= 5) throw new IllegalArgumentException("자동차 이름은 5자 미만만 가능 합니다. name = " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
