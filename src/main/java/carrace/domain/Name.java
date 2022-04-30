package carrace.domain;

public class Name {

    private final String name;

    public Name(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 최대 5자까지 허용됩니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
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
