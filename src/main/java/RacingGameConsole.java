import java.util.*;
import java.util.stream.Collectors;

public class RacingGameConsole {

    private static Scanner scanner = new Scanner(System.in);

    private RacingGame racingGame = new RacingGame(new RandomRacingCarMovingRule());
    private List<String> carNames;
    private int numSteps;

    private void run() {
        input();

        RacingResult result = racingGame.run(carNames, numSteps);

        printGame(result);
    }

    private void input() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesLine = scanner.next();
        carNames = Arrays.stream(carNamesLine.split(","))
                .map(s -> s.trim())
                .collect(Collectors.toList());

        System.out.println("시도할 회수는 몇 회 인가요?");
        numSteps = scanner.nextInt();
    }

    public static String racingStepToString(RacingStep racingStep) {
        return racingStep.getCarNameAndPositionList().stream()
                .map(nameAndPosition -> nameAndPosition.getName() + " : " + String.join("", Collections.nCopies(nameAndPosition.getPosition(), "-")))
                .collect(Collectors.joining("\n"));
    }

    public static String racingStepListToString(ArrayList<RacingStep> racingStepList) {
        return racingStepList.stream()
                .map(racingStep -> racingStepToString(racingStep))
                .collect(Collectors.joining("\n\n"));
    }

    public static void printGame(RacingResult racingResult) {
        System.out.print("\n실행 결과\n" + racingStepListToString(racingResult.getRacingStepList()));

        String winnerNames = racingResult.getWinnerNames().stream()
                .collect(Collectors.joining(","));

        System.out.print("\n\n" + winnerNames + "가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        new RacingGameConsole().run();
    }

}
