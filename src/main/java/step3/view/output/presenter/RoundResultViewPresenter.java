package step3.view.output.presenter;

import step3.view.dto.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

import static step3.view.ViewString.*;

public class RoundResultViewPresenter implements Presenter {
    private final int round;
    private final List<CarDTO> cars;

    public RoundResultViewPresenter(final int round, final List<CarDTO> cars) {
        this.round = round;
        this.cars = cars;
    }

    @Override
    public String present() {
        return createRoundAnnounceView() + NEWLINE + createRoundResultView() + NEWLINE;
    }

    private String createRoundAnnounceView() {
        return ROUND_ANNOUNCEMENT + " " + (round + 1);
    }

    private String createRoundResultView() {
        return cars.stream()
                .map(CarDTO::getLocation)
                .map(position -> createMovingDistanceView(position) + NEWLINE)
                .collect(Collectors.joining());
    }

    private String createMovingDistanceView(final int position) {
        final StringBuilder viewBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            viewBuilder.append(MOVE_CHAR);
        }
        return viewBuilder.toString();
    }
}
