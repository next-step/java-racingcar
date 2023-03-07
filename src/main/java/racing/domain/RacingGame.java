package racing.domain;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> participationCars;
    private final Random random;

    public RacingGame(List<Car> participationCars, Random random) {
        this.participationCars = participationCars;
        this.random = random;
    }

    public void startRace() {
        participationCars.forEach(c -> c.move(random));
    }

    public List<Car> getParticipationCars() {
        return this.participationCars;
    }

    public List<Car> getRacingWinners() {
        Optional<Car> max = participationCars.stream().max(Car::compareTo);
        Car winner = max.orElseThrow();
        return participationCars.stream().filter(c -> c.isEqualLocation(winner)).collect(Collectors.toList());
    }
}
