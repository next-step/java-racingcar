import racingcar.di.CarFactory;
import racingcar.di.CarFactoryImpl;
import racingcar.domain.Car;
import racingcar.utils.RacingTrack;
import racingcar.utils.RacingTrackImpl;
import racingcar.utils.RankPicker;
import racingcar.utils.RankPickerImpl;
import racingcar.view.RacingGameView;
import racingcar.view.RacingGameViewImpl;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactoryImpl();
        RacingGameView racingGameView = new RacingGameViewImpl();
        RankPicker rankPicker = new RankPickerImpl();
        String[] carNames = racingGameView.inputCarNames();
        List<Car> cars = carFactory.makeCars(carNames);

        int playCount = racingGameView.inputPlayCount();

        RacingTrack racingTrack = new RacingTrackImpl();
        racingTrack.run(playCount, () -> racingGameView.printCars(cars));

        List<Car> topRankers = rankPicker.pickTopRankers(cars);
        racingGameView.printWinner(topRankers);
    }
}