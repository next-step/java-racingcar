package step4.vo;

import java.util.List;

public class GameRequestVO {
    private final List<String> carNames;
    private final int count;

    private GameRequestVO(final List<String> carNames, final int count) {
        this.carNames = carNames;
        this.count = count;
    }

    public static GameRequestVO of(final List<String> carNames, final int count) {
        return new GameRequestVO(carNames, count);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getCount() {
        return count;
    }
}
