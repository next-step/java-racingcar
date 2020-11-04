package study.step3;

import study.step3.domain.RealCar;

public class TestingCar extends RealCar {
    private boolean nextGuess;

    public TestingCar() {
        this("blue");
    }

    public TestingCar(String name) {
        super(name);
    }

    @Override
    protected boolean guessMove() {
        return nextGuess;
    }

    public void move(boolean nextGuess) {
        this.nextGuess = nextGuess;
        super.move();
    }
}
