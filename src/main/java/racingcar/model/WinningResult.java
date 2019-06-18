package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {

    private Position position;
    private List<String> names;

    private WinningResult(Position position, List<String> names) {
        this.position = position;
        this.names = names;
    }

    public static WinningResult of(List<Car> cars){
        validateNull(cars);
        Position position = Position.max();

        List<String> names = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return new WinningResult(position, names);
    }

    private static void validateNull(List<Car> cars) {
        if(cars.isEmpty()){
            throw new IllegalArgumentException("Cars can't be null");
        }
    }

    public Position getPosition() {
        return position;
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "WinningResult{" + "position=" + position + ", names=" + names + '}';
    }
}
