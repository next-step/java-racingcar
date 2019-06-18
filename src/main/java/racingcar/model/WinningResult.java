package racingcar.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningResult {

    private Position position;
    private Names names;

    private WinningResult(Position position, Names names) {
        this.position = position;
        this.names = names;
    }

    public static WinningResult of(List<Car> cars){
        validateNull(cars);
        Position position = Position.max();

        List<String> nameList = cars.stream().map(Car::getName).collect(toList());

        return new WinningResult(position, new Names(nameList));
    }

    private static void validateNull(List<Car> cars) {
        if(cars.isEmpty()){
            throw new IllegalArgumentException("cars는 null일 수 없습니다.");
        }
    }

    public int getPosition() {
        return position.parseInt();
    }

    public List<String> getNames() {
        return names.getList();
    }

    @Override
    public String toString() {
        return "WinningResult{" + "position=" + position + ", names=" + names + '}';
    }
}
