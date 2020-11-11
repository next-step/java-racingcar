package racing.model;

public class Name {
    private String name;

    Name(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 필수 값 입니다.");
        }

        if (5 < name.length() ) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
