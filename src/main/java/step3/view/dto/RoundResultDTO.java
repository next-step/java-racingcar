package step3.view.dto;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResultDTO {
    private static final String NEWLINE = "\n";
    private static final char MOVE_CHAR = '-';
    private static final String ROUND_ANNOUNCEMENT = "라운드";

    private final int round;
    private final List<CarDTO> cars;

    public RoundResultDTO(final int round, final List<CarDTO> cars) {
        this.round = round;
        this.cars = cars;
    }

    public String createRoundAnnounceView() {
        return ROUND_ANNOUNCEMENT + " " + (round + 1);
    }

    public String createRoundResultView() {
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
