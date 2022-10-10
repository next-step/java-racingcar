package racing;

import racing.domain.car.Car;
import racing.domain.car.CarFactory;
import racing.domain.car.RandomStrategy;
import racing.domain.race.Race;
import racing.ui.Form;
import racing.ui.InputView;
import racing.ui.OutputView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory(new RandomStrategy());
        Form form = InputView.createForm();
        List<Car> cars = carFactory.create(form.getNameOfCars());
        Race race = new Race(cars, form.getNumberOfPlays());
        race.play();
        OutputView.showResult(race);
    }
}
