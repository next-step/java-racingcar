package cargameracing;

public class Name {
    private final String name;

    public Name(String name) throws Exception {
        if (name.length() > 5) {
            throw new Exception("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }
}
