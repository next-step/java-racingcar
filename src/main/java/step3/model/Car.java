package step3.model;

public class Car {
    private int moveCnt;

    public Car(){
        this.moveCnt = 1;
    }

    public void move(){
        this.moveCnt += 1;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
