package racingcar.backend.domain;

import racingcar.backend.dto.CarDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameRecords {

    private final List<GameRecord> records;

    public GameRecords() {
        this.records = new ArrayList<>();
    }

    public void add(GameRecord gameRecord) {
        records.add(gameRecord);
    }

    public List<CarDto> getWinner() {
        return lastGame().stream()
                .filter(carDto -> carDto.getPosition().equals(maxPosition()))
                .collect(Collectors.toList());
    }

    private Position maxPosition() {
        return lastGame().stream()
                .max(Comparator.comparing(CarDto::getPosition))
                .get()
                .getPosition();
    }

    private List<CarDto> lastGame() {
        return records.get(records.size() - 1).getValue();
    }

    public List<GameRecord> getValues() {
        return records;
    }
}
