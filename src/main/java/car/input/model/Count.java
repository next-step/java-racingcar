package car.input.model;

public class Count {

    private int tryCount;

    public Count(final String count) {
        this.tryCount = toInt(count);
    }

    private int toInt(final String count) {
        int num = Integer.parseInt(count);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
