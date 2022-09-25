public class Car {

    public int currentPosition;
    public int remainMoveCount;

    public Car(int remainMoveCount) {
        this.currentPosition = 0;
        this.remainMoveCount = remainMoveCount;
    }

    public void move(int randomValue) {
        if(randomValue < 0 || randomValue > 9) throw new RuntimeException("not available value");
        if(remainMoveCount <= 0) throw new RuntimeException("out of move count");

        remainMoveCount--;
        if(randomValue < 4) return;
        currentPosition++;
    }
}
