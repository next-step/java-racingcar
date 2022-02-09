package racingcar.domain;

public class Name {

    private static final int NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        isCorrectNameSize(name);
        this.name = name;
    }

    private void isCorrectNameSize(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 빈값입니다!");
        }
        if (NAME_SIZE < name.length()) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과했습니다!");
        }
    }

    public String getName() {
        return name;
    }
}
