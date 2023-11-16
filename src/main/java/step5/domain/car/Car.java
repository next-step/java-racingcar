package step5.domain.car;

public class Car {
    private Name name;
    private Distance distance;

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car defaultOf(String name) {
        Name nameObject = Name.of(name);
        return new Car(nameObject, Distance.one());
    }

    public boolean isDistance(int distanceOfComparing) {
        return this.distance.equals(Distance.of(distanceOfComparing));
    }

    public void move(boolean goOrNot) {
        if (goOrNot) {
            this.distance.addOne();
        }
    }
}
