package racing;

public class Count {

    private Integer count;

    private Count(int count) {
        this.count = count;
    }

    public static Count getInstance(int carCount) {
        return new Count(carCount);
    }

    public int getValue() {
        return count;
    }

}
