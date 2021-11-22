package carracing;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    public static void main(String[] args) {
        List<CarName> carNames = InputView.inputCarNames();
        int round = InputView.inputRound();

        InputView.print("실행 결과");

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Track track = new Track(cars);

        for (int i = 0; i < round; i++) {
            track.forward();
        }

        ResultView.printRounds(track.getRounds());
    }
}
