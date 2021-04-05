package carracing.domain;

public class Name {

    private String name;

    public Name(String name) {
        this.name = name(name);
    }

    private String name(String name) {
        if (name.length() < 1 || name.length() > 5)
            throw new IllegalArgumentException("이름은 1자 이상, 5자를 이하로 입력되어야 합니다.");

        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}