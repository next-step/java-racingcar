package step4.domain.car;

import step4.domain.startegy.NamingStrategy;

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


}

