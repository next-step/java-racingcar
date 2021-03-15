package step4.domain.driver.name;

import step4.domain.startegy.name.NamingStrategy;

import java.util.Objects;

public class Name {

    private String name;

    // 해당 클래스에서는 Car와 같이 move() 함수가 없습니다.
    // 즉, 그저 값을 set/get 밖에 하는 용도이며
    // 만약 인스턴스 필드로 LengthCheckStrategy 를 가진다면 값을 한 번 저장하고 사용하는 비효율이 존재합니다.
    // 그렇기에 LengthCheckStrategy 를 생성자단에서 바로 검사하도록 했습니다.
    private Name(String name, NamingStrategy namingStrategy) {
        if (isNotValidate(name, namingStrategy)) throw new IllegalArgumentException("이름에 사용되기에는 알맞은 값이 아닙니다.");
        this.name = name;
    }

    public static Name from(String name, NamingStrategy lengthCheck) {
        return new Name(name, lengthCheck);
    }

    private boolean isNotValidate(String name, NamingStrategy lengthCheck) {
        return (!(lengthCheck.isValidate(name)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // getName이 있었지만, Getter를 최소화 하고자 toString()을 오버라이딩 했습니다.
    @Override
    public String toString() {
        return name;
    }

}

