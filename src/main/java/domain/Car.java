package domain;

import view.ResultView;

class Car {
    private static final int MOVE_THRS = 4;
    private final Position position = new Position();

    void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= MOVE_THRS) {
            this.position.increase();
        }
    }

    void printCurrentPosition() {
        ResultView.printResult(this.position.toString());
    }
}