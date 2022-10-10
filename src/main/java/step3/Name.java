package step3;

public class Name {

    private String name;

    public Name(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5를 초과할 수 없습니다.");
        }
        this.name = name;
    }
}
