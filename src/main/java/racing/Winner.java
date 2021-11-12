package racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author han
 */
public class Winner {

    private List<Car> winners = new ArrayList<>();
    private Map<Integer, List<Car>> history = new HashMap<>();

    public List<Car> getWinners() {
        return winners;
    }

    public Map<Integer, List<Car>> getHistory() {
        return history;
    }

    public void addHistory(Integer i, List<Car> car) {
        this.history.put(i, car);
    }

    public void addWinner(List<Car> winners) {
        this.winners = winners;
    }
}
