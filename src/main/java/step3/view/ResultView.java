package step3.view;

import step3.domain.CarRacingResult;
import step3.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final String DISTANCE_EXPRESSION = "-";
    private final String WINNER_DELIMITER = ", ";

    private List<CarRacingResult> carRacingResult;

    public ResultView(List<CarRacingResult> carRacingResultList) {
        System.out.println("실행 결과");
        this.carRacingResult = carRacingResultList;
    }

    public void printOutRacingResult() {
        carRacingResult.forEach(carResultDto -> {
            carResultDto.getCarPositionList()
                    .forEach(carPosition -> printCar(carPosition.getCarName(), carPosition.getPosition()));
            System.out.println();
        });
    }

    private void printCar(String carName, int position) {
        System.out.println(carName + ":" + StringUtil.repeat(DISTANCE_EXPRESSION, position));
    }

    public void printOutWinnerCarName() {
        String winnerCarName = carRacingResult.get(getRoundCount())
                .getWinnerCarNames()
                .stream()
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(String.format("%s(이)가 최종 우승했습니다.", winnerCarName));
    }

    private int getRoundCount() {
        return carRacingResult.size() - 1;
    }
}
