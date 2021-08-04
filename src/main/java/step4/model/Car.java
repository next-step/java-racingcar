package step4.model;

public class Car {
    private int index;
    private int move;

    public Car(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getMove() {
        return move;
    }

    public void go(){
        this.move = move+1;
    }
}
