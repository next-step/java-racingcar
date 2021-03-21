package study.step3;

import study.exception.NameInvalidException;

import java.util.Objects;

public class Name {

    private static final String DEFAULT_CAR_NAME = "test";

    private final String name;

    public Name(){
        this(DEFAULT_CAR_NAME);
    }

    public Name(String name){
        nameInvalidCheck(name);
        this.name = name;
    }

    private void nameInvalidCheck(String name){
        throw new NameInvalidException(name);
    }

    public String name() {
        return name;
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
