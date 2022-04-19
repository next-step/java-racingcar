package step3.domain;

import java.util.LinkedList;
import java.util.List;
import step3.exception.NoFinalWinnerException;

public class RacingHistories {

    List<RacingHistory> histories = new LinkedList<>();

    public void add(Cars cars) {
        StringBuilder racingStatus = new StringBuilder();
        cars.getCars().forEach(car -> {
                racingStatus.append(car.getName()).append(" : ");
                racingStatus.append(makePositionDash(car.getPosition()));
                racingStatus.append(System.lineSeparator());
            });

        histories.add(new RacingHistory(cars.firstRankNames(), racingStatus.toString()));
    }

    public String printWinner() {
        if (histories.isEmpty()) {
            throw new NoFinalWinnerException("최종 승자가 없습니다.");
        }

        List<String> firstRankNames = histories.get(histories.size() - 1).getFirstRankNames();

        return String.join(",", firstRankNames);
    }

    private String makePositionDash(int position) {
        return "-".repeat(Math.max(0, position));
    }

    public List<RacingHistory> getHistories() {
        return histories;
    }

}
