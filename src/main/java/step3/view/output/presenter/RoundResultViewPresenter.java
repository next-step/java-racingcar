package step3.view.output.presenter;

import step3.view.dto.CarDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.view.ViewString.*;

public class RoundResultViewPresenter implements Presenter {
    private final List<CarDTO> cars;

    public RoundResultViewPresenter(final List<CarDTO> cars) {
        this.cars = cars;
    }

    @Override
    public String present() {
        return createRoundResultView() + NEWLINE;
    }

    private String createRoundResultView() {
        return cars.stream()
                .map(CarDTO::getLocation)
                .map(position -> createMovingDistanceView(position) + NEWLINE)
                .collect(Collectors.joining());
    }

    private String createMovingDistanceView(final int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> String.valueOf(MOVE_CHAR))
                .collect(Collectors.joining());
    }
}
