package camp.nextstep.edu.racingcar.domain;

public interface CarHelper {
    default Car createCar(String name, int position) {
        final Car car = Car.from(name);
        return car.move(position);
    }
}
