package third_racing;

public class Car {
    private int carNo = 1;
    private int carPosition = 1;

    public Car() {
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getCarPosition() {
        return this.carPosition;
    }

    public void move(){
        this.carPosition++;
    }

    public void carPartIn(int i){
        this.carNo = i;
    }
}
