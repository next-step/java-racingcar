package racingcarrefectoring.model;

public class Car {

    private final Name name;
    private Position position;

    public Car(String carName){
        name = new Name(carName);
        position = new Position(0);
    }

    public Name getName(){
        return name;
    }

    public Position getPosition(){
        return position;
    }

    public void move(){
        position = position.increase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        return position != null ? position.equals(car.position) : car.position == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
