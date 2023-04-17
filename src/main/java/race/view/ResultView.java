package race.view;

import race.car.dto.CarInfoDto;

import java.util.List;

public class ResultView {
    private static final String CAR_SCORE = "-";
    private static final String COLON = " : ";

    private ResultView() {
    }

    public static void printScore(List<List<CarInfoDto>> racingScores) {
        System.out.println("실행 결과");

        for (List<CarInfoDto> carInfoDtos : racingScores) {
            printScoreAtOneTime(carInfoDtos);
        }
    }

    private static void printScoreAtOneTime(List<CarInfoDto> carInfoDtos) {
        for (CarInfoDto carInfoDto : carInfoDtos) {
            System.out.println(carInfoDto.name() + COLON + CAR_SCORE.repeat(carInfoDto.location()));
        }
        System.out.println();
    }
}
