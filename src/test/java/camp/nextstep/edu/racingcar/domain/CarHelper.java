package camp.nextstep.edu.racingcar.domain;

public interface CarHelper {
    default Car createCar(CarName carName, int position) {
        final Car car = Car.from(carName);
        return car.move(position);
    }
}
