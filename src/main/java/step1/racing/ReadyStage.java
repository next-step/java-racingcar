package step1.racing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import step1.racing.data.RacingCar;
import step1.racing.factories.EvaluatorFactory;
import step1.racing.factories.RandomListGeneratorFactory;
import step1.racing.view.CarPositionViewer;

public class ReadyStage {
    private static final Pattern CONTAINS_DOT = Pattern.compile("^-?\\d+\\.\\d+");
    private static final String SPLIT_DELIMITER = ",";
    private static final String CAR_INDICATOR = "-";

    private RandomListGenerator randomListGenerator;
    private PositionSetter positionSetter;
    private RacingCarHandler racingCarHandler;

    private int playTimes;
    private int boundary;

    public ReadyStage() {
        initValues();
    }

    public void play() {
        RacingGame racingGame = new RacingGame(randomListGenerator, positionSetter, racingCarHandler, playTimes,
                                               boundary);
        CarPositionViewer.rendering(racingCarHandler, CAR_INDICATOR);
        racingGame.move();
        CarPositionViewer.rendering(racingCarHandler, CAR_INDICATOR);
        CarPositionViewer.printWinner(racingCarHandler);

    }

    private void initValues() {
        Scanner scanner = new Scanner(System.in);
        String players = scanner.nextLine();
        playTimes = scanner.nextInt();
        boundary = scanner.nextInt();
        String winningThreshold = scanner.next();
        Class type = resolveType(winningThreshold);

        racingCarHandler = initCarPositions(players);
        randomListGenerator = RandomListGeneratorFactory.getRandomListGenerator(type);
        positionSetter = new PositionSetter(EvaluatorFactory.getEvaluator(type), winningThreshold);
    }

    private Class resolveType(String value) {
        if (CONTAINS_DOT.matcher(value).find()) {
            return Float.class;
        }

        return Integer.class;
    }

    private RacingCarHandler initCarPositions(String players) {
        return new RacingCarHandler(Arrays.stream(players.split(SPLIT_DELIMITER))
                                          .map(RacingCar::new)
                                          .collect(Collectors.toList()));
    }
}
