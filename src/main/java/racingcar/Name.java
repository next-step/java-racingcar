package racingcar;

public class Name {

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public Name(Name nameToBeCopied) {
        this.name = nameToBeCopied.name;
    }

    private void validateName(String name) {
        if (name.length() <= 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상, 5글자 이하입니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
