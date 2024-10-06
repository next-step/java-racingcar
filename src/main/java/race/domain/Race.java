package race.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;

    public static RaceResult start(RaceInput raceInput) {
        RacingCars cars = RacingCars.from(raceInput.carNames());

        Map<Integer, List<String>> roundCarStateMessageMap = new HashMap<>();
        for (int round = 0; round < raceInput.gameCount(); round++) {
            List<String> carStateMessages = startRound(cars);
            roundCarStateMessageMap.put(round, carStateMessages);
        }

        List<String> winners = cars.findWinners();

        return new RaceResult(winners, roundCarStateMessageMap);
    }

    private static List<String> startRound(RacingCars cars) {
        List<Integer> randomNumbers = IntStream.range(0, cars.count())
                .map(integer -> generateIntBetween0and9())
                .boxed()
                .collect(Collectors.toList());

        return cars.moveAndReturnCarStateMessages(randomNumbers);
    }

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }
}
