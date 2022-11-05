package carracing.domain;

import java.util.Objects;

public class Name {
    private final String Name;

    private static final int MAX_NAME_LENGTH =5;

    public Name(final String name){
        checkNullAndEmpth(name);
        checkLength(name);
        this.Name=name;
    }

    private void checkLength(String name){
        if(name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    private void checkNullAndEmpth(String name){
        if(name==null||name.isEmpty()||name.equals("")){
            throw new IllegalArgumentException("이름이 Null 혹은 빈문자열 입니다.");
        }
    }

    @Override
    public String toString() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(Name, name.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }
}
