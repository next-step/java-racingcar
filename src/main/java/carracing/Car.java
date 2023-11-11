package carracing;

public class Car {

    private int position;
    public Car() {
        this(0);
    }
    public Car(int position) {
        this.position = position;
    }
    public String getPositionRepeat() {
        return "-".repeat(position);
    }
    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if(value >= 4){
            position++;
        }
    }
}
