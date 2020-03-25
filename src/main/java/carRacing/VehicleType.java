package carRacing;


import carRacing.domain.Car;
import carRacing.domain.MoveStrategy;
import carRacing.domain.Vehicle;

public enum VehicleType {

    CAR {
        Vehicle init(MoveStrategy moveStrategy) {
            return new Car(moveStrategy);
        }
    };


    abstract Vehicle init(MoveStrategy moveStrategy);
}
