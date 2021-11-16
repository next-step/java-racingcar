package study.step_3;

import study.step_3.view.OutputView;

public class RacingCar {

    private final static int condition = 4;
    private int distance;

    public void move(int randomNumber) {
        if (this.canMove(randomNumber)) {
            this.distance++;
        }

        printResult();
    }

    private void printResult() {
        OutputView outputView = new OutputView();
        outputView.printResult(this.distance);
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= condition;
    }

    public int getDistance() {
        return this.distance;
    }

}
