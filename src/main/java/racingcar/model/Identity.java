package racingcar.model;

public class Identity {
    private String id;

    public Identity(String id) {
        if (id.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.id = id;
    }

    public String getIdentity() {
        return this.id;
    }
}
