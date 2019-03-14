package racing.view;

import racing.application.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarsView {
    private List<RacingCarView> views;

    public RacingCarsView(List<RacingCarView> views) {
        this.views = views;
    }

    public List<Integer> getPositions() {
        return views.stream()
                .map(v -> v.getPosition())
                .collect(Collectors.toList());
    }

    public static RacingCarsView toRacingCarsView(List<Car> cars) {
        return new RacingCarsView(cars.stream()
                .map(v-> toRacingCarView(v))
                .collect(Collectors.toList()));
    }

    private static RacingCarView toRacingCarView(Car car) {
        return new RacingCarView(car.getName(), car.getPosition());
    }

    public Stream<RacingCarView> stream() {
        return views.stream();
    }
}