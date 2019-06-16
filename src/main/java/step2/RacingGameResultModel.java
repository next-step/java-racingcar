package step2;

import java.util.Map;

public class SimpleRacingGameResultModel implements ResultModel {
    private final Map<Car, String> resultMap;

    public SimpleRacingGameResultModel(Map<Car, String> resultMap) {
        this.resultMap = resultMap;
    }
}
