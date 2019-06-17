package camp.nextstep.edu.racingcar.view.formatter;

import camp.nextstep.edu.racingcar.domain.Cars;
import camp.nextstep.edu.racingcar.domain.Round;

public class RoundFormatter implements Formatter<Round> {

    private final Formatter<Cars> carsFormatter;

    public RoundFormatter(Formatter<Cars> carsFormatter) {
        this.carsFormatter = carsFormatter;
    }

    @Override
    public String format(Round round) {
        final Cars cars = round.getCars();
        return carsFormatter.format(cars);
    }
}
