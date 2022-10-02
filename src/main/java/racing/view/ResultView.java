package racing.view;

import racing.domain.RacingScore;
import racing.domain.WinnerRacingCars;
import racing.dto.RacingCarDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {}

    public static void titlePrint() {

        System.out.println("실행 결과");
    }

    public static void winnerPrint(final WinnerRacingCars winnerRacingCars) {

        System.out.printf("%s가 최종 우승했습니다.", winnerRacingCars.pick());
    }

    public static void resultPrint(final RacingScore racingScore) {

        totalResultPrint(racingScore.score());
    }

    private static void totalResultPrint(final Map<Integer, List<RacingCarDto>> score) {

        for (Integer integer : score.keySet()) {
            racingPrint(score.get(integer));
            ResultView.blank();
        }
    }

    private static void racingPrint(final List<RacingCarDto> racingCarDtos) {

        racingCarDtos.stream()
                .forEach(racingCar -> {
                    final String stringBuilder = racingCar.getName() +
                            " : " +
                            racingCar.getPosition();
                    System.out.println(stringBuilder);
                });
    }

    private static void blank() {

        System.out.println();
    }
}
