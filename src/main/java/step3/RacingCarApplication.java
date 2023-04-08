package step3;

import step3.domain.Racecourse;
import step3.domain.RacingCar;
import step3.domain.Track;
import step3.util.RacingCreateHelper;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.Scanner;

import static step3.util.RacingCreateHelper.createRacingCars;
import static step3.util.RacingCreateHelper.createTracks;

public class RacingCarApplication {
    private static final Scanner scanner = new Scanner(System.in);

    private static void run() {
        // 입력값 받기
        final int carNumbers = InputView.inputCarNumbers(scanner);
        final int tryNumbers = InputView.inputTryNumbers(scanner);

        // 경기장 세팅
        final List<RacingCar> racingCars = createRacingCars(carNumbers);
        final List<Track> tracks = createTracks(carNumbers);
        final Racecourse racecourse = new Racecourse();
        racecourse.addTracks(tracks);
        for (RacingCar racingCar : racingCars) {
            racecourse.entrance(racingCar);
        }

        // 경기 시작 및 결과 출력
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
