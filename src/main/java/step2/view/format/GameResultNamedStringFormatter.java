package step2.view.format;

import step2.domain.Car;

public class GameResultNamedStringFormatter extends GameResultStringFormatter {
    public GameResultNamedStringFormatter() {
    }

    public GameResultNamedStringFormatter(final String carSymbol) {
        super(carSymbol);
    }

    @Override
    protected String formatCar(final Car car) {
        return car.getName() + "\t:\t" + super.formatCar(car);
    }
}
