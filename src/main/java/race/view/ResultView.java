package race.view;

import race.domain.car.dto.CarInfoDto;

import java.util.*;

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

        printWinner(racingScores);
    }

    private static void printScoreAtOneTime(List<CarInfoDto> carInfoDtos) {
        for (CarInfoDto carInfoDto : carInfoDtos) {
            System.out.println(carInfoDto.name() + COLON + CAR_SCORE.repeat(carInfoDto.location()));
        }
        System.out.println();
    }

    /**
     * 우승자 출력
     */
    private static void printWinner(List<List<CarInfoDto>> racingScores) {
        final List<CarInfoDto> racingResult = racingScores.get(racingScores.size() - 1);

        System.out.println(String.join(", ", winnerNameFilter(racingResult)) + "가 최종 우승했습니다.");
    }

    /**
     * 우승자 확인
     */
    private static List<String> winnerNameFilter(List<CarInfoDto> racingResult) {
        final Map<Integer, List<String>> resultMap = new HashMap<>();

        for (CarInfoDto carInfoDto : racingResult) {
            final List<String> value = resultMap.getOrDefault(carInfoDto.location(), new ArrayList<>());
            value.add(carInfoDto.name());

            resultMap.put(carInfoDto.location(), value);
        }

        return resultMap.get(Collections.max(resultMap.keySet()));
    }
}
