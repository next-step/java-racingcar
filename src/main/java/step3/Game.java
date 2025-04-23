package step3;

import step3.dto.PositionResponse;
import step3.dto.RaceRoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Cars cars;
    private final RaceCount raceCount;

    public Game(int carCount, int raceCount) {
        this.cars = new Cars(carCount);
        this.raceCount = new RaceCount(raceCount);
    }

    public Game(Cars cars, RaceCount raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public List<RaceRoundResult> start() {
        List<RaceRoundResult> responses = new ArrayList<>();

        while (!raceCount.isDone()) {
            List<Position> positions = raceCount.play(() -> cars.move());
            responses.add(
                    new RaceRoundResult(
                            positions.stream()
                                    .map(PositionResponse::new)
                                    .collect(Collectors.toList())
                    )
            );
        }

        return responses;
    }
}
