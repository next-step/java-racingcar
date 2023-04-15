package step3;

import step3.domain.Racecourse;
import step3.domain.RacingCar;
import step3.domain.Track;
import step3.dto.RacingCarInputDto;
import step3.util.RacingCreateHelper;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static step3.util.RacingCreateHelper.createRacingCars;
import static step3.util.RacingCreateHelper.createTracks;

public class RacingCarApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String racingCarSeparator = ",";

    private static void run() {
        final RacingCarInputDto racingCarInputDto = inputRacingCar();
        final List<RacingCar> racingCars = RacingCreateHelper.createRacingCars(splitCarNames(racingCarInputDto.getCarNames()));
        final Racecourse racecourse = createRacecourse(racingCars.size());

        enterRacingCars(racecourse, racingCars);
        startRacing(racecourse, racingCarInputDto.getTryNumbers());
    }

    private static List<String> splitCarNames(final String carNames) {
        return Arrays.asList(carNames.split(racingCarSeparator));
    }

    private static RacingCarInputDto inputRacingCar() {
        final String carNames = InputView.inputCarNames(scanner);
        final int tryNumbers = InputView.inputTryNumbers(scanner);
        return new RacingCarInputDto(carNames, tryNumbers);
    }

    private static Racecourse createRacecourse(final int racingCarAmount) {
        final List<Track> tracks = createTracks(racingCarAmount);
        return new Racecourse(tracks);
    }

    private static void enterRacingCars(Racecourse racecourse, List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racecourse.enter(racingCar);
        }
    }

    private static void startRacing(final Racecourse racecourse, final int tryNumbers) {
        ResultView.printResultTitle();
        for (int i = 0; i < tryNumbers; i++) {
            racecourse.signalToForward();
            ResultView.printCarPosition(racecourse);
        }

        ResultView.printTopRanking(racecourse);
    }

    public static void main(String[] args) {
        RacingCarApplication.run();
    }
}
