package racingcar.service.dto;

import racingcar.service.domain.Car;
import racingcar.utils.Preconditions;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResultDTO {

    private List<Record> records;

    private RoundResultDTO(List<Record> records) {
        this.records = records;
    }

    public static RoundResultDTO of(List<Record> records) {
        Preconditions.checkNotNull(records, "records는 필수값입니다.");
        return new RoundResultDTO(records);
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getWinnerName() {
        return getLastRound().getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private Record getLastRound() {
        return records.get(records.size() - 1);
    }
}
