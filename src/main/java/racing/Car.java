package racing;

public class Car implements Comparable<Car>{
    private String name;
    private int movingRange;

    public Car(String name,int movingRange) {
        if (name.length() > 5) throw new IllegalArgumentException("이름은 5자 이내로 .");
        this.name = name;
        this.movingRange = movingRange;
    }
    public Car(String name) {
        this(name, 0);
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
