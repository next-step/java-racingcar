package study.step4.try2.domain;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("양의 정수만 입력해주세요.");
        }
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public int getPosition() {
        return this.position;
    }

    public void increase() {
        this.position++;
    }
}
