package step3;

import step3.domain.Racecourse;
import step3.domain.RacingCar;
import step3.domain.Track;
import step3.dto.RacingCarInputDto;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.Scanner;

import static step3.util.RacingCreateHelper.createRacingCars;
import static step3.util.RacingCreateHelper.createTracks;

public class RacingCarApplication {
    private static final Scanner scanner = new Scanner(System.in);

    private static void run() {
        final RacingCarInputDto racingCarInputDto = inputRacingCar();
        final Racecourse racecourse = createRacecourse(racingCarInputDto.getCarNumbers());
        enterRacingCars(racecourse, createRacingCars(racingCarInputDto.getCarNumbers()));
        startRacing(racecourse, racingCarInputDto.getTryNumbers());
    }

    private static RacingCarInputDto inputRacingCar() {
        final int carNumbers = InputView.inputCarNumbers(scanner);
        final int tryNumbers = InputView.inputTryNumbers(scanner);
        return new RacingCarInputDto(carNumbers, tryNumbers);
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
    }

    public static void main(String[] args) {
        RacingCarApplication.run();
    }
}
