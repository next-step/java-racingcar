package step4.domain;

import step4.vo.Name;
import step4.vo.Names;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class GameHistory {
    private final List<Cars> history = new ArrayList<>();
    private Names winnerNames;

    public void save(Cars tempHistory) {
        history.add(tempHistory);
    }

    private Cars getTimeHistory(Integer time) {
        Cars log = history.get(time);
        if (log == null) {
            throw new IllegalArgumentException("history가 존재하지 않습니다.");
        }
        return log;
    }

    public void makeWinner(Integer lastTime) {
        Cars lastHistory = getTimeHistory(lastTime);
        Car winPosition = getWinPositionCar(lastHistory);
        List<Name> winnerNameList = lastHistory.getCars().stream()
                .filter(car -> car.equalsPosition(winPosition))
                .map(Car::getName)
                .collect(Collectors.toList());

        Names names = new Names();
        names.addNames(winnerNameList);
        this.winnerNames = names;
    }

    private Car getWinPositionCar(Cars cars) {
        return cars.getCars().stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Cars> getHistory() {
        return history;
    }

    public Names getWinnerNames() {
        return winnerNames;
    }

}
