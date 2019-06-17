package step2;

import java.util.List;

public class ResultView {
    private final RacingGameResultModel racingGameResultModel;

    public ResultView(RacingGameResultModel racingGameResultModel) {
        this.racingGameResultModel = racingGameResultModel;
    }

    public void printRacingGameResult() {
        List<Cars> result = racingGameResultModel.getCars();
        for (Cars cars : result) {
            cars.getCars().forEach(car -> System.out.println("=> " + getMovingPosition(car.getPosition())));
            System.out.println();
        }
    }

    private String getMovingPosition(Integer position) {
        String movingPosition = "";
        for (int i = 0; i < position; i++) {
            movingPosition += "-";
        }
        return movingPosition;
    }
}
