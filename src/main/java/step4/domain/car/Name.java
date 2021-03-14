package step4.domain.car;

public class Name {

    private String name;
    // private LengthStartegy lengthStartegy;
    // 전략 패턴을 만들자.

    private Name(String name) {
        if(name.length() > 10) throw new IllegalArgumentException("이름에 사용되기에는 알맞은 값이 아닙니다.");
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    // private boolean



}

