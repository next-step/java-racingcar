package step4.view;


import step4.domain.driver.Driver;
import step4.domain.dto.RacingCarResponseDto;

import java.util.List;

public class ResultView {
    private static final String NEWLINE = "\n";

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static ResultView instance;

    private ResultView() {
    }

    public static ResultView getInstance() {
        if (isInstanceNull()) {
            instance = new ResultView();
        }
        return instance;
    }

    private static boolean isInstanceNull(){
        return instance == null;
    }

    public void printResult(RacingCarResponseDto responseDto, Integer newlineStandard) {
        List<Driver> racingRecords = responseDto.getRacingRecords();

        System.out.println("실행 결과");
        for(int index=ONE; index <= racingRecords.size(); index++){
            System.out.println(getDriverByIndex(racingRecords, index));
            if(isRemainderZeroByNewStandard(index, newlineStandard)) System.out.print(NEWLINE);
        }

    }

    private Driver getDriverByIndex(List<Driver> racingRecords, Integer index) {
        return racingRecords.get(getOriginalIndex(index));
    }

    private Integer getOriginalIndex(Integer index) {
        if (index <= ZERO) throw new IllegalArgumentException("0 이하의 값은 입력할 수 없습니다.");
        return (index - ONE);
    }

    private boolean isRemainderZeroByNewStandard(Integer index, Integer newlineStandard) {
        return (index % newlineStandard) == ZERO;
    }

}
