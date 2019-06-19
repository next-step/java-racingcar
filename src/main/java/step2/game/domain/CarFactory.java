package step2.game.domain;

public interface CarFactory {

    default Car createCar(Integer carNo) {
        return new Car(carNo, new DefaultMoveStrategy());
    }

    default Car createCar(Integer carNo, MoveStrategy moveStrategy) {
        return new Car(carNo, moveStrategy);
    }
}
