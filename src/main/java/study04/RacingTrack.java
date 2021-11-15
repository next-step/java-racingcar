package study04;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingTrack {

    private final Map<String, RacingCar> racingCars;

    private RacingTrack(Map<String, RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingTrack createRacingTrack(List<String> racingCarNames) {
        List<Engine> engines = new ArrayList<>();
        List<Distance> distances = new ArrayList<>();
        racingCarNames.forEach(racingCarName -> {
            engines.add(Engine.createEngine());
            distances.add(Distance.createDistance());
        });

        return createRacingTrack(racingCarNames, engines, distances);
    }

    public static RacingTrack createRacingTrack(List<String> racingCarNames, List<Engine> engines, List<Distance> distances) {
        Map<String, RacingCar> newRacingTrack = new LinkedHashMap<>();
        IntStream.range(0, racingCarNames.size())
                .forEach(i -> newRacingTrack.put(racingCarNames.get(i), RacingCar.createRacingCar(racingCarNames.get(i), engines.get(i), distances.get(i))));

        return new RacingTrack(newRacingTrack);
    }

    public void run() {
        racingCars.forEach((name, racingCar) -> racingCar.run());
    }

    public RacingCar getRacingCar(String racingCarName) {
        return this.racingCars.get(racingCarName);
    }

    @Override
    public String toString() {
        StringBuffer trackDescription = new StringBuffer("레이싱 트랙 - 현재 상태\n");
        racingCars.forEach((name, racingCar) -> trackDescription.append(racingCar.toString()).append("\n"));
        return trackDescription.toString();
    }
}
