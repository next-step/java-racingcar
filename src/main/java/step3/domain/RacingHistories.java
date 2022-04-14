package step3.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import step3.exception.NoFinalWinnerException;

public class RacingHistories {

    List<RacingHistory> histories = new LinkedList<>();

    public void add(Cars cars) {
        StringBuilder racingStatus = new StringBuilder();
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            racingStatus.append(car.getName() + " : ");
            racingStatus.append(printPosition(car.getPosition()));
            racingStatus.append(System.lineSeparator());
        }

        histories.add(new RacingHistory(cars.firstRankNames(), racingStatus.toString()));
    }

    public String printWinner() {
        if (histories.isEmpty()) {
            throw new NoFinalWinnerException("최종 승자가 없습니다.");
        }

        List<String> firstRankNames = histories.get(histories.size() - 1).getFirstRankNames();

        return firstRankNames.stream()
            .collect(Collectors.joining(","));
    }

    private String printPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            sb.append('-');
        }
        return sb.toString();
    }

    public List<RacingHistory> getHistories() {
        return histories;
    }

}
