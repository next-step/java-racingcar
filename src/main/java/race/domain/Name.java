package race.domain;


public class Name {

    private final String name;

    public Name(String name){
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("차 이름은 빈 값 혹은 공백일 수 없습니다.");
        }
        if (5 < name.length()) {
            throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
