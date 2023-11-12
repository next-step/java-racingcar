package racing;

public class Car {
    private Distance distance;
    private final Name name;
    private Car(Name name) {
        this.distance = Distance.defaultOf(1);
        this.name = name;
    }

    private Car(Name name,int howFar) {
        this.distance = Distance.defaultOf(howFar);
        this.name = name;
    }

    public static Car defaultOf(String name) {
        return new Car(Name.defaultOf(name));
    }
    public static Car defaultOf(String name, int howFar) {
        return new Car(Name.defaultOf(name),howFar);
    }

    public void move() {
        this.distance.plus(1);
    }

    // 자동차끼리 비교
    //
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


    public boolean equalsDistance(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return distance.equals(car.distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name=" + name +
                '}';
    }
}
