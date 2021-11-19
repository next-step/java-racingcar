package study.racingcar.model;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if(name.length() < 1 || name.length() > 5){
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하 입니다.");
        }
        this.name = name;
    }

    public String getName(){
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
