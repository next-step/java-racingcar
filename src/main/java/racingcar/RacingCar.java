package racingcar;

import racingcar.pattern.NumberGenerator;

public class RacingCar  {
    private Cars cars;
    private int round;
    private final NumberGenerator numberGenerator;

    public RacingCar(Cars cars, int round, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.setRound(round);
        this.numberGenerator = numberGenerator;
    }

    private void setRound(int round) {
        if(round < 0) {
            throw new IllegalArgumentException("round는 음수가 될 수 없습니다");
        }
        this.round = round;
    }

    public void playRound() {
        decreaseRound();
        cars.play(numberGenerator);
    }

    private void decreaseRound() {
        if(round <= 0) {
            throw new IllegalStateException("모든 라운드가 종료 되었습니다.");
        }
        round = round - 1;
    }

}
