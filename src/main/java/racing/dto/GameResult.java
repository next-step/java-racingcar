package racing.dto;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class GameResult { // 값 객체

    private List<Integer> list;

    public GameResult(List<Integer> onceResult) {
        this.list = onceResult;
    }

    public List<Integer> getResult() {
        return this.list;
    }
}
