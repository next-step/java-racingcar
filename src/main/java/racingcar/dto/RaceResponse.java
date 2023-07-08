package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;

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

        private CarResponse(final Name name, final Position position) {
            this.name = name.getValue();
            this.position = position.getValue();
        }

        public CarResponse(final Car car) {
            this(car.getName(), car.getPosition());
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}
