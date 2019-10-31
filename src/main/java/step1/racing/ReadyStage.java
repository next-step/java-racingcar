package step1.racing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadyStage {
    private static final Pattern CONTAINS_DOT = Pattern.compile("^-?\\d+\\.\\d+");

    private final Scanner scanner;

    private RandomListGenerator randomListGenerator;
    private PositionSetter positionSetter;

    private int players;
    private int playTimes;
    private int boundary;

    private String winningThreshold;
    private Class type;

    public ReadyStage(Scanner scanner) {
        this.scanner = new Scanner(System.in);
        initValues();
    }

    public void play() {
        RacingGame racingGame = new RacingGame(randomListGenerator, positionSetter, players, playTimes, boundary);
        racingGame.move();
    }

    private void initValues() {
        players = scanner.nextInt();
        playTimes = scanner.nextInt();
        boundary = scanner.nextInt();
        winningThreshold = scanner.next();
        type = resolveType(winningThreshold);

        randomListGenerator = RandomListGeneratorFactory.getRandomListGenerator(type);
        positionSetter = new PositionSetter(EvaluatorFactory.getEvaluator(type), winningThreshold);
    }

    private Class resolveType(String value) {
        if (CONTAINS_DOT.matcher(value).find()) {
            return Float.class;
        }

        return Integer.class;
    }
}
