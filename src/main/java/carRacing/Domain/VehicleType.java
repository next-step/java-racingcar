package carRacing.Domain;


public enum VehicleType {

    CAR {
        Vehicle init(MoveStrategy moveStrategy) {
            return new Car(moveStrategy);
        }
    };


    abstract Vehicle init(MoveStrategy moveStrategy);
}
