package racingcar.domain;

public class Record {
    private String name;
    private int position;
    private int attempt;

    public Record(String name, int position, int attempt) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다: " + name);
        }

        if (position < 0 || attempt < 0) {
            throw new IllegalArgumentException("양수의 입력값만 받을 수 있습니다 [position: " + position + "][attempt: " + attempt + "]");
        }

        this.name = name;
        this.position = position;
        this.attempt = attempt;
    }

    public int getPosition() {
        return position;
    }

    public int getAttempt() {
        return attempt;
    }

    public String getName() {
        return name;
    }
}
