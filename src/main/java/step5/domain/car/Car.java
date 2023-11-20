package step5.domain.car;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Distance distance;

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car defaultOf(String name) {
        Name nameObject = Name.of(name);
        return new Car(nameObject, Distance.one());
    }

    public static Car defaultOf(String name, int distance) {
        return new Car(Name.of(name), Distance.of(distance));
    }
    public static Car defaultOf(Name name, Distance distance) {
        return new Car(name, distance);
    }
    public Car deepCopy() {
        return Car.defaultOf(this.name.deepCopy(), this.distance.deepCopy());

    }

    public boolean sameDistance(int distanceOfComparing) {
        return this.distance.equals(Distance.of(distanceOfComparing));
    }

    public void move(boolean goOrNot) {
        if (goOrNot) {
            this.distance.addOne();
        }
    }

    public boolean fartherThan(Car comparisonTarget) {
        return this.distance.fartherThan(comparisonTarget.distance);
    }
    public boolean sameDistance(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(distance, car.distance);
    }


    public String statusToString() {
        String name = this.nameToString();
        String distance = this.distanceToString();
        return name + " : " + distance;
    }
    public String nameToString() {
        return this.name.toString();
    }
    private String distanceToString() {
        return this.distance.statusToString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(name, car.name)) return false;
        return Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }


}
