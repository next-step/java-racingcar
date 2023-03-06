package car.ui;

public class GameResult<T> {

    private final int totalCount;
    private final T data;

    public GameResult(int totalCount, T data) {
        this.totalCount = totalCount;
        this.data = data;
    }
}
