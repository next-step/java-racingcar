package racingcar.view;

import java.util.List;
import racingcar.domain.dto.CarDto;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String POSITION_INDICATOR = "-";

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
        System.out.println(progress);
    }
}
