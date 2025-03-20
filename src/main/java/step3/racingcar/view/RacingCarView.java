package step3.racingcar.view;

import step3.racingcar.model.RacingCar;

public class RacingCarView {

    private final RacingCar car;

    public RacingCarView(RacingCar car) {
        this.car = car;
    }

    public void showCar() {
        if (this.car.position() == 0) {
            System.out.printf("Car #%d : (%d)\n", this.car.no(), this.car.position());
            return;
        }
        System.out.printf("Car #%d : %s (%d)\n", this.car.no(), "-".repeat(this.car.position()), this.car.position());
    }

}
