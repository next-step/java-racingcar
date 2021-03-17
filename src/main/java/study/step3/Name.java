package study.step3;

import java.util.Objects;

public class Name {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;


    private final String name;

    public Name(){
        this("test");
    }

    public Name(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("차 이름은 빈 값이 될 수 없습니다.");
        }
        if(name.length() >= CAR_NAME_LENGTH_LIMIT){
            throw new IllegalArgumentException("차 이름의 길이는 5이상이 될 수 없습니다.");
        }
        this.name = name;
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
