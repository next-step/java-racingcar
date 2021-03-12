package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.dto.RacingCarResponseDto;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";
    private static final String NEWLINE = "\n";

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static ResultView instance;

    private ResultView() {
    }

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    public void printResult(RacingCarResponseDto responseDto, Integer newlineStandard) {
        StringBuilder result = init();
        result.append(createRacingCarGameResult(responseDto.getRacingRecords(), newlineStandard));
        System.out.println(result.toString());
    }

    private StringBuilder init() {
        return new StringBuilder().append(NEWLINE).append("실행 결과").append(NEWLINE);
    }

    private StringBuilder createRacingCarGameResult(List<Car> results, Integer newlineStandard) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ONE; i <= results.size(); i++) {
            for (int j = ONE; j <= results.get(getOriginalIndex(i)).getStatus(); j++) {
                stringBuilder.append(DASH);
            }
            stringBuilder.append(NEWLINE);
            if (isRemainderZeroByNewStandard(i, newlineStandard)) {
                stringBuilder.append(NEWLINE);
            }
        }
        return stringBuilder;
    }

    private Integer getOriginalIndex(Integer index) {
        if (index <= ZERO) throw new IllegalArgumentException("0 이하의 값은 입력할 수 없습니다.");
        return (index - ONE);
    }

    private boolean isRemainderZeroByNewStandard(Integer index, Integer newlineStandard) {
        return (index % newlineStandard) == ZERO;
    }

}
