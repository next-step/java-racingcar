package racingcar.console;

import com.google.common.base.Strings;
import racingcar.application.InputView;
import racingcar.application.RacingCarView;
import racingcar.application.RacingService;
import racingcar.application.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingConsole {
    private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);
    private static final String POSITION_DISPLAY = "-";

    public static void run(final RacingService racingService) {
        final List<ResultView> views = racingService.race(new InputView(enterNumberOfCars(), enterTime()));
        printResult(views);
    }

    private static int enterNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return CONSOLE_SCANNER.nextInt();
    }

    private static int enterTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return CONSOLE_SCANNER.nextInt();
    }

    private static void printResult(final List<ResultView> views) {
        System.out.println("실행 결과");
        views.stream()
                .forEach(view -> {
                    printView(view);
                    System.out.println();
                })
        ;
    }

    private static void printView(final ResultView view) {
        final List<RacingCarView> racingCarViews = view.getViews()
                .get();
        for (final RacingCarView racingCarView : racingCarViews) {
            System.out.println(Strings.repeat(POSITION_DISPLAY, racingCarView.getPosition()));
        }
    }
}
