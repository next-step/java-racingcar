package step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final String DISTANCE_EXPRESSION = "-";
    private final String WINNER_DELIMITER = ", ";

    private List<CarResultDto> carRacingResult;

    public ResultView(List<CarResultDto> carResultDtoList) {
        System.out.println("실행 결과");
        this.carRacingResult = carResultDtoList;
    }

    public void printOutRacingResult() {
        carRacingResult.forEach(carResultDto -> {
            carResultDto.getCarDtoList()
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
