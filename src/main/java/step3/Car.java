package step3;

public class Car {

    private int count;

    public void tryMove(int count){
        this.count += 4 <= count? 1 : 0;
    }

    public int getCount() {
        return count;
    }
}
