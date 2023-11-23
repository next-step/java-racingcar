package step4.racing;

import step4.racing.inout.OutPutView;

public class Car {
    private Distance distance;
    private final Name name;
    private Car(Name name) {
        this.distance = Distance.of(1);
        this.name = name;
    }

    private Car(Name name,int howFar) {
        this.distance = Distance.of(howFar);
        this.name = name;
    }

    public static Car defaultOf(String name) {
        return new Car(Name.defaultOf(name));
    }
    public static Car defaultOf(String name, int howFar) {
        return new Car(Name.defaultOf(name),howFar);
    }

    public void move(boolean canMove) {
        if (canMove) {
            this.distance.plus(1);
        }
    }

    public Car winnerIs(Car car) {
        if (this.fartherThan(car.distance)) {
            return this;
        }
        return car;
    }

    // 받은 차와 거리 비교
    private boolean fartherThan(Distance distance) {
        return this.distance.fartherThan(distance);
    }

    public void printStatus(OutPutView outPutView) {
        outPutView.printStatus(this.name,this.distance);
    }
    public void printName(OutPutView outPutView) {
        this.name.print(outPutView);
    }

    public boolean equalsDistance(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return distance.equals(car.distance);
    }

    @Override
    public String toString() {
        return "step3.Car{" +
                "distance=" + distance +
                ", name=" + name +
                '}';
    }


}
