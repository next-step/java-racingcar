package racing;

public class Name {

    private final String name;

    public Name(String name) {
        String trimName = name.trim();
        validate(trimName);
        this.name = trimName;
    }

    private void validate(String trimName) {
        if (trimName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        if (trimName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공란일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
