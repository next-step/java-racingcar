package step4.domain;


import util.Exception;
import java.util.Objects;

public class Name {

    private final String name;
    private static final int NAME_LENGTH = 5;

    public String getName() {
        return name;
    }

    public Name(String name) {
        if(name.trim().isEmpty())
           Exception.IllegalArgumentException("자동차 이름이 존재해야 합니다.");
        if(name.length() > NAME_LENGTH)
            Exception.IllegalArgumentException("자동차 이름의 길이는 5글자를 넘기면 안됩니다.");
        this.name = name;
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
