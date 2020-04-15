package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.service.response.RacingDto;

import java.util.List;

public class ResultView {
    private static final String CARS_NAME_DELIMITER = ",";
    private static final String CAR_STATE_STR = "-";

    private static final String CAR_STATE_FORMAT = "%s : %s\n";
    private static final String RACING_WINNERS_FORMAT = "%s가 최종 우승했습니다.";
    private static final String RESULT_INFO_COMMENT = "\n실행 결과\n";

    public static void printRacingResult(RacingDto racingDto) {
        List<Cars> results = racingDto.getRoundResults();

        StringBuilder stringBuilder = new StringBuilder(RESULT_INFO_COMMENT);
        for (Cars cars : results) {
            positionToView(cars, stringBuilder);
        }
        stringBuilder.append(winnersToView(racingDto.getWinnerNames()));

        System.out.println(stringBuilder.toString());
    }

    public static void positionToView(Cars cars, StringBuilder stringBuilder) {
        for (Car car : cars.getList()) {
            stringBuilder.append(positionToView(car));
        }

        stringBuilder.append("\n");
    }

    public static String positionToView(Car car) {
        StringBuilder stringBuilder = new StringBuilder();

        int times = car.getPosition();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(CAR_STATE_STR);
        }

        return String.format(CAR_STATE_FORMAT, car.getName(), stringBuilder.toString());
    }

    public static String winnersToView(List<String> winnerNames) {
        return String.format(RACING_WINNERS_FORMAT, String.join(CARS_NAME_DELIMITER, winnerNames));
    }
}
