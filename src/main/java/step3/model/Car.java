package step3.model;

public class Car {
    private String name;
    private int position;
    private final int MOVE_BOUNDARY = 4;
    public Car(int carNo) {
        this.name = String.valueOf(carNo);
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean move){
        if(move){
            position++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
