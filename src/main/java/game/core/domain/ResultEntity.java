package game.core.domain;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class ResultEntity<T> {

    private T result;

    public ResultEntity(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

}
