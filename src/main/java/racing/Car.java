package racing;

public class Car implements Comparable<Car> {
    private String carName;
    private int movePosition;

    public Car(String carName) {
        this.carName = carName;
        this.movePosition = 0;
    }

    public void move() {
        movePosition++;
    }

    public String getCarName(){
        return this.carName;
    }
    public int getMovePosition(){
        return this.movePosition;
    }

    @Override
    public int compareTo(Car o) {
        if(this.movePosition < o.movePosition){
            return -1;
        }else if(this.movePosition > o.movePosition){
            return 1;
        }

        return 0;
    }
}