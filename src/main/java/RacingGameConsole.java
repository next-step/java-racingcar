import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameConsole {

    private RacingGame racingGame = new RacingGame(new RandomRacingCarMovingRule());
    private int numCars;
    private int numSteps;

    private void run() {
        input();

        ArrayList<RacingStep> result = racingGame.run(numCars, numSteps);

        printGame(result);
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        numCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        numSteps = scanner.nextInt();
    }

    public static String racingStepToString(RacingStep racingStep) {
        return racingStep.getCarPositionList().stream()
                .map(pos -> String.join("", Collections.nCopies(pos, "-")))
                .collect(Collectors.joining("\n"));
    }

    public static String racingStepListToString(ArrayList<RacingStep> racingStepArrayList) {
        return racingStepArrayList.stream()
                .map(racingStep -> racingStepToString(racingStep))
                .collect(Collectors.joining("\n\n"));
    }

    public static void printGame(ArrayList<RacingStep> racingStepArrayList) {
        System.out.print("\n실행 결과\n" + racingStepListToString(racingStepArrayList));
    }

    public static void main(String[] args) {
        new RacingGameConsole().run();
    }

}
