package step4.domain.car.name;

public final class Name {
    private final int STANDARD = 5;
    private final String name;

    public Name(String name) {
        if(isInvalid(name)) {
            throw new IllegalArgumentException("유효하지 않은 이름을 사용했습니다.");
        }
        this.name = name;
    }

    private final boolean isInvalid(String name) {
        return name.length() > STANDARD;
    }

    public final String name() {
        return name;
    }
}
