package Racing;

public class Car implements Comparable<Car>{
    private String name;
    private int movingRange;

    public Car(String name,int movingRange) {
        this.name = name;
        this.movingRange = movingRange;
    }
    public Car(String name) {
        this.name = name;
        this.movingRange = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovingRange() {
        return movingRange;
    }
    public void moved() { movingRange += 1; }
    public int compareTo(Car o) {
        return Integer.compare(o.movingRange, movingRange);
    }
}
