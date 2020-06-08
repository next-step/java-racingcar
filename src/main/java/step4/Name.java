package step4;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        invalid(name);
        this.name = name;
    }

    private void invalid(String name) {
        if(name == "") {
            throw new IllegalArgumentException();
        }
        if(name == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}