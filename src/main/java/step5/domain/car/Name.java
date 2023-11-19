package step5.domain.car;

import step5.model.enums.StandardNumber;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name.length() > StandardNumber.NAME_LENGTH_LIMIT_STANDARD.number()) {
            throw new IllegalArgumentException("이름의 길이가 알맞지 않습니다.");
        }
        return new Name(name);
    }
    public Name deepCopy() {
        return Name.of(this.name);
    }
    @Override
    public String toString() {
        return  name;
    }

}
