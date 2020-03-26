package step5.view;

import java.util.List;

import step5.domain.Car;
import step5.domain.Cars;

public class ResultView {
    private String winnerNames;
    private List<Cars> moveCarPositions;

    public ResultView(String winnerNames,
                      List<Cars> moveCarPositions) {
        this.winnerNames = winnerNames;
        this.moveCarPositions = moveCarPositions;
    }

    public String getResultCarPosition(Cars cars, String result) {
        for (Car car : cars.getCars()) {
            result += car.getName() + ":" + car.getPosition() + "\n";
        }
        return result;
    }

    public String printMoveProcess() {
        String result = "";
        for (Cars moveCarPosition : moveCarPositions) {
            result = getResultCarPosition(moveCarPosition, result);
            result += "\n";
        }
        return result;
    }

    public String resultWinnerUser() {
        return winnerNames + "가 최종 우승했습니다.";
    }

}
