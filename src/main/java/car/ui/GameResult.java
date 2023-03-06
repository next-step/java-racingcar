package car.ui;

public class GameResult<T> {

    private int totalCount;
    private T data;

    public GameResult(int totalCount, T data) {
        this.totalCount = totalCount;
        this.data = data;
    }
}
