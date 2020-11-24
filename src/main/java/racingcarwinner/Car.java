package racingcarwinner;

public class Car {

    private Position position;
    private final Name name;
    public Car(String name){
        this.position = new Position(0);
        this.name = new Name(name);

    }
    public Position getPosition() {
        return position;
    }

    public Name getName(){
        return this.name;
    }

    public void move() {
        position = new Position(position.getIncreaseValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!position.equals(car.position)) return false;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}