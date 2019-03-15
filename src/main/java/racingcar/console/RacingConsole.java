package racingcar.console;

import com.google.common.base.Strings;
import racingcar.application.RacingService;
import racingcar.application.request.InputView;
import racingcar.application.response.RacingView;
import racingcar.application.response.RacingViews;
import racingcar.application.response.ResultView;
import racingcar.application.response.WinnerViews;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingConsole {
    private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);
    private static final String POSITION_DISPLAY = "-";

    public static void run(final RacingService racingService) {
        final ResultView view = racingService.race(new InputView(enterInputName(), enterTime()));
        printRaceProgress(view.getRaceProgress());
        printWinners(view.getWinners());
    }

    private static String enterInputName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return CONSOLE_SCANNER.next();
    }

    private static int enterTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return CONSOLE_SCANNER.nextInt();
    }

    private static void printRaceProgress(final RacingViews views) {
        System.out.println("\n실행 결과");
        views.get()
                .stream()
                .forEach(view -> {
                    printRacing(view);
                    System.out.println();
                })
        ;
    }

    private static void printWinners(final WinnerViews views) {
        final String names = views.get()
                .stream()
                .collect(Collectors.joining(", "))
                ;
        System.out.print(names + "가 최종 우승했습니다.");
    }

    private static void printRacing(final RacingView view) {
        final RacingCars racingCars = view.getRacingCars();
        for (final RacingCar racingCar : racingCars.get()) {
            System.out.println(changeToRacingCarPrintFormat(racingCar));
        }
    }

    private static String changeToRacingCarPrintFormat(final RacingCar racingCar) {
        return new StringBuilder()
                .append(racingCar.getName())
                .append(" : ")
                .append(Strings.repeat(POSITION_DISPLAY, racingCar.getPosition()))
                .toString()
                ;
    }
}
