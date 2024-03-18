package racingcar.domain;

public class Name {

    private final String name;
    private final int MAX_NAME_SIZE = 5;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new RuntimeException("자동차 이름은 5자를 초과 할 수 없습니다.");
        }
    }
}
