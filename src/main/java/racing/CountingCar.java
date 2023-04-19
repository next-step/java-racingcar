package racing;

public class CountingCar extends Car {

    private int moveCount;

    public CountingCar(String name) {
        super(name);
    }

    @Override
    public void move(int randomNumber) {
        super.move(randomNumber);
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
