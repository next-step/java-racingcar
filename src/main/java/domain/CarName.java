package domain;

class CarName {
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    CarName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}