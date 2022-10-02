package racing.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RaceHistory
{
    private final List<Record> history = new ArrayList<>();
    private static final String DELEMETER = ",";

    public void save(int turn, List<Car> carList)
    {
        carList.forEach(car -> history.add(Record.of(turn, car.getCarName(), car.getPosition())));
    }

    public int getLastTurn()
    {
        return history
            .stream()
            .mapToInt(Record::getTurn)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }

    public List<Record> getHistoryByTurn(int turn)
    {
        return history
            .stream()
            .filter(record -> record.isSameTurn(turn))
            .collect(Collectors.toUnmodifiableList());
    }

    public String getWinner()
    {
        int maxPosition = getMaxPosition();
        return getHistoryByTurn(getLastTurn())
            .stream()
            .filter(record -> record.isSamePosition(maxPosition))
            .map(Record::getCarName)
            .collect(Collectors.joining(DELEMETER));
    }

    private int getMaxPosition()
    {
        return history.stream()
            .max(Comparator.comparingInt(Record::getPosition))
            .orElseThrow(NoSuchElementException::new)
            .getPosition();
    }
}
