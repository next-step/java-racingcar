package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public final class RaceResponse {

    private final List<CarResponse> cars;

    public RaceResponse(final Cars cars) {
        this.cars = cars.getCars()
                .stream()
                .map(CarResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarResponse> getCars() {
        return cars;
    }

    public static final class CarResponse {

        private final String name;
        private final int position;

        private CarResponse(final String name, final int position) {
            this.name = name;
            this.position = position;
        }

        public CarResponse(final Car car) {
            this(car.getName(), car.getPosition().getPosition());
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}
