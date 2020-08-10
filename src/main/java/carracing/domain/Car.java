package carracing.domain;

public class Car {

    final static int MOVE_POSITION = 4;

    private int position = 0;
    private int carNumber;
    private String output = "";

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public void setPosition(int random) {
        this.position = random;
    }

    public boolean isMove() {
        if(position < MOVE_POSITION) return false;
        return true;
    }

    public void getGraphics() {
       String carNumber = String.valueOf(this.carNumber) + " : ";
        if(isMove()){
            this.output += "-";
        }
        System.out.println(carNumber + this.output);
    }
}
