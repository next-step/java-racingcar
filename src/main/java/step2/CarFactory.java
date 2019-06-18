package step2;

public interface CarFactory {

    default Car createCar(Integer carNo, Integer position, MoveStrategy moveStrategy) {
        return new Car(carNo, position, moveStrategy);
    }
}
