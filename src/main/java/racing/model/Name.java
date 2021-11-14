package racing.model;

public class Name {
    private final String name;
    private static Integer criteria = 5;
    public Name(String name) {
        validationCheck(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validationCheck(String name) {

        if (name.length() > criteria) {
            throw new IllegalArgumentException("이름의 길이가 5가 넘습니다.");
        }
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
