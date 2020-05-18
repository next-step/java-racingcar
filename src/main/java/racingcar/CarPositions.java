package racingcar;

import racingcar.exception.NotYetMovedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarPositions {

    private List<CarPosition> positions = new ArrayList<>();

    public void add(CarPosition carPosition) {
        positions.add(carPosition);
    }

    public int size() {
        return positions.size();
    }

    public CarPosition get(int index) {
        return positions.get(index);
    }

    public List<String> getLeaders() {
        Integer maxPosition = getMaxPosition();

        return positions.stream()
                .filter(p -> p.getPosition() == maxPosition)
                .map(CarPosition::getName)
                .collect(Collectors.toList());
    }

    private Integer getMaxPosition() {
        return positions.stream()
                    .map(CarPosition::getPosition)
                    .max(Integer::compareTo)
                    .orElseThrow(NotYetMovedException::new);
    }
}
