package step1.racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import step1.racing.data.RacingCar;
import step1.racing.factories.EvaluatorFactory;
import step1.racing.factories.RandomListGeneratorFactory;

public class ReadyStage {
    private static final Pattern CONTAINS_DOT = Pattern.compile("^-?\\d+\\.\\d+");
    private static final String SPLIT_DELIMITER = ",";

    private final Scanner scanner;

    private RandomListGenerator randomListGenerator;
    private PositionSetter positionSetter;
    private List<RacingCar> carPositions;

    private int playTimes;
    private int boundary;

    public ReadyStage() {
        this.scanner = new Scanner(System.in);
        initValues();
    }

    public void play() {
        RacingGame racingGame = new RacingGame(randomListGenerator, positionSetter, carPositions, playTimes, boundary);
        racingGame.move();
    }

    private void initValues() {
        String players = scanner.nextLine();
        playTimes = scanner.nextInt();
        boundary = scanner.nextInt();
        String winningThreshold = scanner.next();
        Class type = resolveType(winningThreshold);

        carPositions = initCarPositions(players);
        randomListGenerator = RandomListGeneratorFactory.getRandomListGenerator(type);
        positionSetter = new PositionSetter(EvaluatorFactory.getEvaluator(type), winningThreshold);
    }

    private Class resolveType(String value) {
        if (CONTAINS_DOT.matcher(value).find()) {
            return Float.class;
        }

        return Integer.class;
    }

    private List<RacingCar> initCarPositions(String players) {
        return Arrays.stream(players.split(SPLIT_DELIMITER))
              .map(RacingCar::new)
              .collect(Collectors.toList());
    }
}
