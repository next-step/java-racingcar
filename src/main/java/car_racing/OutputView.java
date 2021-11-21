package car_racing;

import java.util.List;

public class OutputView {

    private static final String OUT_MESSAGE_GAME_ENDS = "\n--게임이 끝났습니다.--\n";
    private static final String OUT_MESSAGE_CAR_RACING_RESULT = "실행 결과";
    private static final String OUT_MESSAGE_WINNER_ANNOUNCE_PHRASE = "가 우승했습니다.";
    private static final String CAR_MOVE_SIGNAL = "-";
    private static final String NAME_SEPARATOR = " : ";
    private static final String NAME_SEPARATOR_FOR_WINNERS = ", ";
    private static final String ONE_ROUND_ENDS_SIGNAL = "\n";

    public void showCarRacingGameOutput(CarRacingResultHistory carRacingResultHistory) {
        System.out.println(OUT_MESSAGE_GAME_ENDS);
        System.out.println(OUT_MESSAGE_CAR_RACING_RESULT);

        List<List<CarRacingResult>> racingResults = carRacingResultHistory.getRacingResults();

        // TODO: 3중 for 문 개선
        StringBuilder result = buildResult(racingResults);
        System.out.println(result.toString());

        String winnersStr = buildWinners(carRacingResultHistory);
        System.out.println(winnersStr + OUT_MESSAGE_WINNER_ANNOUNCE_PHRASE);
    }

    public StringBuilder buildResult(List<List<CarRacingResult>> roundResults) {
        StringBuilder result = new StringBuilder();

        for (List<CarRacingResult> roundResult: roundResults) {
            result.append(buildEachRoundResult(roundResult));
            result.append(ONE_ROUND_ENDS_SIGNAL);
        }
        return result;
    }

    public StringBuilder buildEachRoundResult(List<CarRacingResult> roundResult) {
        StringBuilder result = new StringBuilder();

        for(CarRacingResult carResult: roundResult) {
            result.append(buildEachCarResult(carResult));
            result.append(ONE_ROUND_ENDS_SIGNAL);
        }

        return result;
    }

    public StringBuilder buildEachCarResult(CarRacingResult carResult) {
        StringBuilder result = new StringBuilder();
        result.append(carResult.getName());
        result.append(NAME_SEPARATOR);
        result.append(buildCarPositionStatus(carResult));

        return result;
    }

    public StringBuilder buildCarPositionStatus(CarRacingResult racingResult) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < racingResult.getPosition(); i++) {
            result.append(CAR_MOVE_SIGNAL);
        }

        return result;
    }

    public String buildWinners(CarRacingResultHistory racingResult) {
        Cars cars = racingResult.getWinners();
        List<String> winnersName = cars.getNames();
        return String.join(NAME_SEPARATOR_FOR_WINNERS, winnersName);
    }

}
