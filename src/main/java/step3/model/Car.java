package step3.model;

public class Car {
    private int move;

    public int getMove() {
        return move;
    }

    public int go(){
        this.move = move+1;
        return move;
    }
}
