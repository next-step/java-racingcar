package car_racing;

import java.util.List;

public class OutputView {

    private static final String OUT_MESSAGE_GAME_ENDS = "\n--게임이 끝났습니다.--\n";
    private static final String OUT_MESSAGE_CAR_RACING_RESULT = "실행 결과";
    private static final String CAR_MOVE_SIGNAL = "-";
    private static final String NAME_SEPARATOR = " : ";
    private static final String ONE_ROUND_ENDS_SIGNAL = "\n";

    public void showCarRacingGameOutput(CarRacingResult carRacingResult) {
        System.out.println(OUT_MESSAGE_GAME_ENDS);
        System.out.println(OUT_MESSAGE_CAR_RACING_RESULT);

        List<Cars> racingResult = carRacingResult.getRacingResult();
        // TODO: 3중 for 문 개선
        StringBuilder result = buildResult(racingResult);
        System.out.println(result.toString());
    }

    public StringBuilder buildResult(List<Cars> roundResult) {
        StringBuilder result = new StringBuilder();

        for (Cars cars : roundResult) {
            result.append(buildEachRoundResult(cars));
            result.append(ONE_ROUND_ENDS_SIGNAL);
        }

        return result;
    }

    public StringBuilder buildEachRoundResult(Cars roundResult) {
        StringBuilder result = new StringBuilder();

        for(Car car: roundResult.getCars()) {
            result.append(buildEachCarResult(car));
            result.append(ONE_ROUND_ENDS_SIGNAL);
        }

        return result;
    }

    public StringBuilder buildEachCarResult(Car car) {
        StringBuilder result = new StringBuilder();
        result.append(car.getName());
        result.append(NAME_SEPARATOR);
        result.append(buildCarPositionStatus(car));

        return null;
    }

    public StringBuilder buildCarPositionStatus(Car car) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            result.append(CAR_MOVE_SIGNAL);
        }

        return result;
    }


}
