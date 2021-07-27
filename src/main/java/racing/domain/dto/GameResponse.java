package racing.domain.dto;

import racing.domain.car.Cars;

import java.util.Iterator;
import java.util.List;

public class GameResponse implements Iterable<Cars> {
    private List<Cars> values;

    public GameResponse(List<Cars> values) {
        this.values = values;
    }

    public Cars lastValue() {
        return values.get(values.size() - 1);
    }

    @Override
    public Iterator<Cars> iterator() {
        return values.iterator();
    }
}
