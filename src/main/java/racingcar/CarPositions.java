package racingcar;

import racingcar.exception.NotYetMovedException;

import java.util.List;
import java.util.stream.Collectors;

public class CarPositions {

    private List<CarPosition> positions;

    public CarPositions(List<CarPosition> positions) {
        this.positions = positions;
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
                .sorted()
                .findFirst()
                .orElseThrow(NotYetMovedException::new)
                .getPosition();
    }
}
