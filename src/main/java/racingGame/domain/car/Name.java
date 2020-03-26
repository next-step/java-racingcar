package racingGame.domain.car;


class Name {
    private String name;

    Name(String name) {
        verifyName(name);
        this.name = name;
    }

    private void verifyName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("올바른 이름이 아닙니다.");
        }
    }

    String getName() {
        return name;
    }
}
