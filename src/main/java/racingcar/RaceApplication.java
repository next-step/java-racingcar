package racingcar;

import java.io.IOException;
import java.util.Arrays;

public class RaceApplication {
    public static void main(String[] args) throws IOException {
        Request request = InputView.init();

        Car[] cars = Arrays.stream(request.getNames())
                .map(Car::create)
                .toArray(Car[]::new);

        Race race = Race.of(cars, request.getTotalRound());

        OutputView.start();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < request.getTotalRound(); i++) {
            race.play(randomNumberGenerator);
            OutputView.printRound(new Response(race.getCars()));
        }

        OutputView.finish(race.findWinners());
    }
}
