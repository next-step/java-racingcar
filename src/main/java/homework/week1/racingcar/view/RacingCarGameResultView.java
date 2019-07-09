package homework.week1.racingcar.view;

import homework.week1.racingcar.domain.RacingCarGameResult;

import java.util.List;

public class RacingCarGameResultView {
    private static final String WINNER_CAR_NAME_GUIDE = "가 최종 우승했습니다.";
    private static final String RUN_SYMBOL = "-";

    private RacingCarGameResultView() {}

    public static RacingCarGameResultView newInstance() {
        return new RacingCarGameResultView();
    }

    public void printRaceResultCars(RacingCarGameResult gameResult) {
        gameResult.getResultCars().stream()
                .forEach(t -> printCar(t.getName(), t.getPosition()));
    }

    public void printCar(String carName, int position) {
        String positionSymbol = "";
        for (int index = 0 ; index < position; index++) {
            positionSymbol += RUN_SYMBOL;
        }
        System.out.println(carName + " : " + positionSymbol);
    }

    public void printWinnerCars(List<String> carNames) {
        System.out.println(String.join(", ", carNames) + WINNER_CAR_NAME_GUIDE);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
