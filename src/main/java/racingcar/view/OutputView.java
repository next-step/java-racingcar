package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNERS_PREFIX = "최종 우승자 : ";
    private static final String CAR_DELIMITER = ", ";
    private static final String CAR_INFIX = " : ";

    public void printBeforeResult() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printProgress(List<CarDto> cars) {
        for (CarDto carDto : cars) {
            printProgress(carDto);
        }
        System.out.println();
    }

    private void printProgress(CarDto carDto) {
        int numberIndicator = carDto.getPosition();
        String progress = POSITION_INDICATOR.repeat(numberIndicator);
        System.out.println(carDto.getCarName() + CAR_INFIX + progress);
    }

    public void printWinners(List<CarDto> winners) {
        System.out.println(WINNERS_PREFIX + joinNamesOf(winners));
    }

    private String joinNamesOf(List<CarDto> cars) {
        return cars.stream()
                .map(CarDto::getCarName)
                .collect(Collectors.joining(CAR_DELIMITER));
    }

}
