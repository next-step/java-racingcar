package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String HYPHEN_SIGN = "-";
    private static final String RESULT_MSG = "실행 결과";
    private static final String WINNER_MSG = "가 최종 우승했습니다.";

    public ResultView() {
        System.out.println();
        System.out.println(RESULT_MSG);
    }

    public void racingShow(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(draw(racingCar));
        }
        System.out.println();
    }

    public String draw(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getCarName());
        sb.append(" : ");
        for (int i = 0; i < racingCar.getMoveCount(); i ++) {
            sb.append(HYPHEN_SIGN);
        }

        return sb.toString();
    }

    public void drawWinner(List<RacingCar> winnerRacingCars) {
        System.out.println();
        String winnerNames = winnerRacingCars.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
        StringBuilder sb = new StringBuilder();
        sb.append(winnerNames).append(WINNER_MSG);
        System.out.println(sb.toString());
    }
}
