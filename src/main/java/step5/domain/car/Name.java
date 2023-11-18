package step5.domain.car;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 알맞지 않습니다.");
        }
        return new Name(name);
    }

    @Override
    public String toString() {
        return  name;
    }
}
