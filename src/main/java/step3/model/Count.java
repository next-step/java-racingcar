package step3.model;

public class Count {

    private final int count;

    public Count(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count 는 0보다 작을 수 없습니다.");
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
