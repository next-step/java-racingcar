package racing;

import racing.domain.Car;

class CountingCar extends Car {

    private int moveCount;

    CountingCar(String name) {
        super(name);
    }

//    @Override
//    public void move(NumberGenerator generator) {
//        super.move(generator);
//        moveCount++;
//    }

    int getMoveCount() {
        return moveCount;
    }

}
