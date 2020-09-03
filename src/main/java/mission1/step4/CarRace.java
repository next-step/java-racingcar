package mission1.step4;

import mission1.step4.util.CarUtil;
import mission1.step4.view.RenderView;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;

import java.util.Objects;

public class CarRace {

    private CarEntry carEntry = new CarEntry();
    private int executionNumber;

    private CarRace(int executionNumber) {
        this.executionNumber = executionNumber;
    }

    public static CarRace getInstance(int executionNumber) {
        if (executionNumber < 1) {
            throw new IllegalArgumentException("레이스는 적어도 1회 이상 진행되어야 합니다.");
        }

        return new CarRace(executionNumber);
    }

    public void join(Car car) {
        if (Objects.isNull(car)) {
            throw new IllegalArgumentException("레이스에 참여할 차량은 필수 값 입니다.");
        }

        carEntry.regist(car);
    }

    public void start() {
        for (int i = 0; i < executionNumber; i++) {
            carEntry.move(CarUtil.getRandomValue());
            RenderView.showCarProgress(carEntry);
        }
        RenderView.showRaceWinner(carEntry.getRaceWinner());
    }
}




