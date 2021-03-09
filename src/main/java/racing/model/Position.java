package racing.model;

public class Position {

    private int position;

    public Position(int position) {
        valid(position);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    /**
     * 자동차 위치를 이동시켜주는 메서드
     */
    public void move() {
        position = position + 1;
    }

    public void valid(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션은 음수일 수 없습니다.");
        }
    }
}
