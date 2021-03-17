package step4.model;

public class Car implements Comparable<Car>{

    private int distance;
    private String name;

    Car(String name){
        this.distance = 0;
        this.name = name;
    }

    void move(MoveStrategy moveStrategy){
        this.distance += moveStrategy.getDistance();
    }

    public int getDistance(){
        return this.distance;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.distance, this.distance);
    }
}
