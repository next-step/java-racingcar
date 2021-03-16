package step4.view;

import step4.domain.driver.Driver;
import step4.domain.dto.RacingCarResponseDto;

import java.util.List;

public class ResultView {
    private static final String NEWLINE = "\n";
    private static final String COMMA = ",";

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

    private static boolean isInstanceNull() {
        return instance == null;
    }

    public void printResult(RacingCarResponseDto responseDto, int driversLength) {
        List<Driver> racingRecords = responseDto.getRacingRecords();

        System.out.println("실행 결과");
        for (int index = ONE; index <= racingRecords.size(); index++) {
            System.out.println(getDriverByIndex(racingRecords, index));
            if (isRemainderZeroByNewStandard(index, driversLength)) System.out.print(NEWLINE);
        }

        List<Driver> lastRoundRacingRecords = getLastRoundRacingRecords(racingRecords, driversLength);
        System.out.println(getWinners(lastRoundRacingRecords, getTopRecordValue(lastRoundRacingRecords)));
    }

    private int getTopRecordValue(List<Driver> lastRoundRacingRecords) {
        return lastRoundRacingRecords.stream()
                .mapToInt(driver -> driver.getCarStatusLength())
                .max()
                .orElseGet(() -> ZERO);
    }

    private String getWinners(List<Driver> lastRoundRacingRecords, int topRecordValue) {
        StringBuilder stringBuilder = new StringBuilder();
        lastRoundRacingRecords
                .stream()
                .filter(driver -> driver.getCarStatusLength() == topRecordValue)
                .forEach(driver -> stringBuilder.append(driver.getName()).append(COMMA));
        stringBuilder.setLength(stringBuilder.length() - ONE);
        stringBuilder.append("가 최종 우승했습니다.");
        return stringBuilder.toString();
    }

    private List<Driver> getLastRoundRacingRecords(List<Driver> drivers, int driversSize) {
        return drivers.subList(drivers.size() - driversSize, drivers.size());
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
