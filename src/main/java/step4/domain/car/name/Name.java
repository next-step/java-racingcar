package step4.domain.car.name;

public final class Name {

    private final String name;

    public Name(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 이름을 사용했습니다.");
        }
        this.name = name;
    }

    public final String name() {
        return name;
    }
}
