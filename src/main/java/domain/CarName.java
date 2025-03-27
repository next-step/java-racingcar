package domain;

class CarName {
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if (this.name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        if (this.name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}