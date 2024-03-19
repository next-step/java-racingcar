package racing;

public class Count {

    private Integer count;

    private Count(int count) {
        this.count = count;
    }

    public static Count carCount(int carCount) {
        return new Count(carCount);
    }

    public static Count tryCount(int tryCount) {
        return new Count(tryCount);
    }

    public int getValue() {
        return count;
    }

}
