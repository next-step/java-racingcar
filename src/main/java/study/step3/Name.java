package study.step3;

import java.util.Objects;

public class Name {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final String DEFAULT_CAR_NAME = "test";

    private final String name;

    public Name(){
        this(DEFAULT_CAR_NAME);
    }

    public Name(String name) {
        blankCheck(name);
        lengthCheck(name);
        this.name = name;
    }

    private void blankCheck(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("차 이름은 빈 값이 될 수 없습니다.");
        }
    }

    private void lengthCheck(String name){
        if(name.length() >= CAR_NAME_LENGTH_LIMIT){
            throw new IllegalArgumentException("차 이름의 길이는 5이상이 될 수 없습니다.");
        }
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
