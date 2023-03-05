package car.ui;

public class Result<T> {

    private int totalCount;
    private T data;

    public Result(int totalCount, T data) {
        this.totalCount = totalCount;
        this.data = data;
    }
}
