package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.RacingGame;
import autoracing.domain.RacingRule;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)";
    private static final String QUESTION_TOTAL_ROUNDS = "시도할 횟수는 몇 회인가요?";

    private final List<String> carNames;
    private final int totalRounds;

    public InputView(List<String> carNames, int totalRounds) {
        this.carNames = carNames;
        this.totalRounds = totalRounds;
    }

    public static RacingGame createFromConsole(RacingRule rule) {
        InputView inputView = InputView.takeInput(System.in);
        RacingGame newGame = new RacingGame(inputView.getTotalRounds(), inputView.getCars());
        newGame.setRule(rule);
        return newGame;
    }

    public static InputView takeInput(InputStream inputStream) {
        Scanner scan = new Scanner(inputStream);

        List<String> numberOfCars = takeCarNames(scan);
        int totalRounds = takeTotalRounds(scan);
        System.out.println();

        scan.close();

        return new InputView(numberOfCars, totalRounds);
    }

    private static List<String> takeCarNames(Scanner scan) {
        System.out.println(QUESTION_CAR_NAMES);
        return parseCarNames(scan.nextLine());
    }

    private static List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.trim().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static int takeTotalRounds(Scanner scan) {
        System.out.println(QUESTION_TOTAL_ROUNDS);
        return Integer.parseInt(scan.nextLine().trim());
    }

    public List<Car> getCars() {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public int getTotalRounds() {
        return totalRounds;
    }
}
