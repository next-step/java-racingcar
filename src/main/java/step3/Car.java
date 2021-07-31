package step3;

public class Car {
    private int move;

    public Car() {
        this.move = 0;
    }

    public int getMove() {
        return move;
    }

    public void go(){
        this.move += 1;
    }
}
