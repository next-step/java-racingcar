package racing;

import racing.domain.Car;

class CountingCar extends Car {

    private int moveCount;

    CountingCar(String name) {
        super(name);
    }

    @Override
    public void move(int randomNumber) {
        super.move(randomNumber);
        moveCount++;
    }

    int getMoveCount() {
        return moveCount;
    }

}
