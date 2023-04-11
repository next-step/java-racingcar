package game.domain;

import game.util.NumberGenerator;

public class Car {
    private static final int MOVE_CRITERIA = 4;
    
    private final CarActions carActions = new CarActions();
    private final NumberGenerator numberGenerator;

    public Car(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
        addAction(numberGenerator.generate());
    }

    private void addAction(int number) {
        if (isMove(number)) {
            carActions.addMove();
            return;
        }
        carActions.addStop();
    }

    private boolean isMove(int number) {
        return number >= MOVE_CRITERIA;
    }

    public CarAction positionOfRep(int rep) {
        return carActions.action(rep);
    }

    public int moveCount() {
        return carActions.size();
    }
}