package step3.domain;

public class Car {
    private Position position;
    private CarName name;

    public Car(String name) throws IllegalArgumentException {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void proceed() {
        position.proceed();
    }

    public void proceedWithPolicy(ProceedPolicy proceedPolicy) {
        if (proceedPolicy.canMoveForward()) {
            proceed();
        }
    }

    public String getName() {
        return this.name.getName();
    }
}
