package racingcar.model;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() > 5 || name.length() <= 0) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 4 글자를 만족해야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        return name != null ? name.equals(name1.name) : name1.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
