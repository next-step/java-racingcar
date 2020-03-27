package carRacing.Domain;


public enum VehicleType {

    CAR {
        Vehicle init(String name, MoveStrategy moveStrategy) {
            return new Car(name, moveStrategy);
        }
    };


    abstract Vehicle init(String name, MoveStrategy moveStrategy);
}
