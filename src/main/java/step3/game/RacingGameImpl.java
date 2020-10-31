package step3.game;

import step3.Constant;
import step3.car.Car;
import step3.factory.RacingCarFactory;
import step3.view.ResultView;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RacingGameImpl extends RacingGame {
    private final Random random = new Random();

    @Override
    public Integer getNumber() {
        return random.nextInt(Constant.RANDOM_MAX_NUMBER);
    }

    @Override
    public void execute(RacingInfomation infomation) {
        isValidInformation(infomation);

        Integer number = infomation.getNumberOfCar();
        Integer playCount = infomation.getPlayCount();

        ResultView resultView = ResultView.getInstance();
        RacingCarFactory factory = RacingCarFactory.getFactory();

        List<Car> createdCars = factory.createCars(number);
        createdCars.forEach(this::addCar);

        for (int i = 0; i < playCount; i++) {
            notifyCars();
            resultView.execute(gameProgress());
        }
    }

    private void isValidInformation(RacingInfomation infomation) {
        if (Objects.isNull(infomation)||(infomation.getNumberOfCar() <= 0 && infomation.getPlayCount() <= 0)) {
            throw new IllegalArgumentException(Constant.EMPTY_NULL_ERROR);
        }
    }
}
