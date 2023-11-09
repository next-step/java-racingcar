package carRacing;


public class Car implements Comparable<Car> {
    private int distance = 0;
    private Name name;
    private MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
    }


    public void move(int number) {
        if (movingStrategy.isRide(number)) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return name.getName();
    }

    public boolean isMaxDistance(int maxDistance) {
        return maxDistance == distance;
    }

    public int findLongerDistance(int number) {
        return Math.max(number, distance);

    }

    @Override
    public int compareTo(Car car) {
        return this.distance - car.getDistance();

    }
}
