package step4;

import java.util.List;

public class ResultView {
    private String winnerNames;
    private List<Car> resultCarPositions;
    private List<List<Car>> moveCarPositions;

    public ResultView(String winnerNames, List<Car> resultCarPositions,
                      List<List<Car>> moveCarPositions) {
        this.winnerNames = winnerNames;
        this.resultCarPositions = resultCarPositions;
        this.moveCarPositions = moveCarPositions;
    }

    private String getResultCarPosition(List<Car> cars, String result) {
        for (Car car : cars) {
            result += car.getName() + ":" + car.getRacingResult() + "\n";
        }
        return result;
    }

    public String printResult() {
        String result = "";
        result = getResultCarPosition(resultCarPositions, result);
        return result;
    }

    public String printMoveProcess() {
        String result = "";
        for (List<Car> moveCarPosition : moveCarPositions) {
            result = getResultCarPosition(moveCarPosition, result);
            result += "\n";
        }
        return result;
    }

    public String resultWinnerUser() {
        return winnerNames + "가 최종 우승했습니다.";
    }

}
