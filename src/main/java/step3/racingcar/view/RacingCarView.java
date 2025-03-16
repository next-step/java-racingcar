package step3.racingcar.view;

import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarResult;

public class RacingCarView {

    private RacingCar car;

    public RacingCarView(RacingCar car) {
        this.car = car;
    }

    public void showCar() {
        if (this.car.roundResult().equals(RacingCarResult.STOP)) {
            if (this.car.position() == 0) {
                System.out.printf("Car #%d [STOP] : (%d)\n", this.car.no(), this.car.position());
                return;
            }
            System.out.printf("Car #%d [STOP] : %s (%d)\n", this.car.no(), "-".repeat(this.car.position()), this.car.position());
        }

        if (this.car.roundResult().equals(RacingCarResult.GO)) {
            System.out.printf("Car #%d [ GO ] : %s (%d)\n", this.car.no(), "-".repeat(this.car.position()), this.car.position());
        }
    }

}
