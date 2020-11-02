package step3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.util.Preconditions.checkArgument;

public class Main {
    public static class NextStepRacingCarSimulation {
        private final InputView inputView;

        public NextStepRacingCarSimulation(final InputView inputView) {
            this.inputView = inputView;
        }

        public void start() {
            final SimulationCondition condition = inputView.listen();
            final RacingCarSimulator simulator = new RacingCarSimulator(condition);
            final SimulationResult simulateResult = simulator.getSimulateResult();
            final ResultView resultView = new ResultView(simulateResult);
            Printer.print(resultView);
        }
    }

    public static class Printer {
        public static void println(final Object x) {
            System.out.println(x);
        }

        public static void print(final Object x) {
            System.out.print(x);
        }
    }

    //TODO:: 더 세부적으로 나누기
    public static class InputView {
        public SimulationCondition listen() {
            final Scanner scanner = new Scanner(System.in);
            Printer.println("자동차 대수는 몇 대 인가요?");
            final int numberOfCar = 3;
            Printer.println(numberOfCar);
//            final int numberOfCar = scanner.nextInt();
            Printer.println("시도할 회수는 몇 회 인가요?");
            final int numberOfAttempts = 5;
            Printer.println(numberOfAttempts);
//            final int numberOfAttempts = scanner.nextInt();
            return new SimulationCondition(numberOfCar, numberOfAttempts);
        }
    }

    public static class SimulationCondition {
        private final int numberOfCar;
        private final int numberOfAttempts;

        public SimulationCondition(final int numberOfCar, final int numberOfAttempts) {
            //TODO:: validation 추가
            this.numberOfCar = numberOfCar;
            this.numberOfAttempts = numberOfAttempts;
        }

        public int getNumberOfCar() {
            return numberOfCar;
        }

        public int getNumberOfAttempts() {
            return numberOfAttempts;
        }
    }

    public static class RacingCarSimulator {
        private static final int UNIT_OF_FORWARD = 1;
        private final int numberOfCar;
        private final int numberOfAttempts;

        public RacingCarSimulator(final SimulationCondition condition) {
            this.numberOfCar = condition.getNumberOfCar();
            this.numberOfAttempts = condition.getNumberOfAttempts();
        }

        public SimulationResult getSimulateResult() {
            checkArgument(true, "not ready");
            final List<RacingCar> racingCars = RacingCarFactory.createCars(numberOfCar);
            final RacingMap racingMap = new RacingMap(numberOfCar);
            final List<Snapshot> snapshots = new ArrayList<>(numberOfAttempts);

            simulate(racingCars, racingMap, snapshots);

            return new SimulationResult(snapshots, racingCars);
        }

        private void simulate(final List<RacingCar> racingCars, final RacingMap racingMap, final List<Snapshot> snapshots) {
            for (int round = 0; round < numberOfAttempts; round++) {
                moveRacingCarInMapIfMovable(racingCars, racingMap);
                saveSnapshot(round, racingMap, snapshots);
            }
        }

        private void saveSnapshot(final int round, final RacingMap racingMap, final List<Snapshot> snapshots) {
            final Snapshot snapshot = new Snapshot(round, racingMap);
            snapshots.add(snapshot);
        }

        private void moveRacingCarInMapIfMovable(final List<RacingCar> racingCars, final RacingMap racingMap) {
            racingCars.stream()
                    .filter(RacingCar::isMovable)
                    .forEach(racingCar -> moveRacingCarInMap(racingCar, racingMap));
        }

        private void moveRacingCarInMap(final RacingCar racingCar, final RacingMap racingMap) {
            racingMap.move(racingCar.getId(), UNIT_OF_FORWARD);
        }
    }

    public static class SimulationResult {
        private final List<Snapshot> snapshots;
        private final List<RacingCar> racingCars;

        public SimulationResult(final List<Snapshot> snapshots, final List<RacingCar> racingCars) {
            this.snapshots = Collections.unmodifiableList(snapshots);
            this.racingCars = Collections.unmodifiableList(racingCars);
        }

        public List<Snapshot> getSnapshots() {
            return snapshots;
        }

        public List<RacingCar> getRacingCars() {
            return racingCars;
        }
    }

    public static class RacingCarFactory {
        public static List<RacingCar> createCars(final int numberOfCar) {
            return IntStream.range(0, numberOfCar)
                    .mapToObj(RacingCar::new)
                    .collect(Collectors.toList());
        }
    }

    public static class RacingCar {
        private static final Random RANDOM = new Random(System.currentTimeMillis());
        private static final int RANDOM_BOUND = 10;
        private static final int MINIMUM_MOVABLE_VALUE = 4;

        private final int id;

        public RacingCar(final int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public boolean isMovable() {
            final int randomValue = RANDOM.nextInt(RANDOM_BOUND);
            return randomValue >= MINIMUM_MOVABLE_VALUE;
        }
    }

    public static class Snapshot {
        private final int number;
        private final RacingMap racingMap;

        public Snapshot(final int number, final RacingMap racingMap) {
            this.number = number;
            this.racingMap = racingMap.clone();
        }

        public int getNumber() {
            return number;
        }

        public RacingMap getRacingMap() {
            return racingMap;
        }
    }

    public static class RacingMap {
        private final int[] location;

        public RacingMap(final int numberOfCar) {
            this.location = new int[numberOfCar];
        }

        private RacingMap(final int[] location) {
            this.location = location;
        }

        public void move(final int id, final int unitOfForward) {
            location[id] += unitOfForward;
        }

        public RacingMap clone() {
            return new RacingMap(location.clone());
        }

        public int findPosition(final int id) {
            return location[id];
        }
    }

    public static class ResultView {
        private static final char MOVE_CHAR = '-' ;
        private static final String NEWLINE = "\n";
        private static final String RESULT_ANNOUNCEMENT = NEWLINE + "실행결과" + NEWLINE;
        private static final String ROUND_ANNOUNCEMENT = "라운드";
        private final String view;


        public ResultView(final SimulationResult simulationResult) {
            final StringBuilder viewBuilder = new StringBuilder(RESULT_ANNOUNCEMENT);
            final List<Snapshot> snapshots = simulationResult.getSnapshots();
            final List<RacingCar> racingCars = simulationResult.getRacingCars();

            for (Snapshot snapshot : snapshots) {
                final RacingMap racingMap = snapshot.getRacingMap();
                viewBuilder.append(createRoundView(snapshot));
                viewBuilder.append(NEWLINE);
                viewBuilder.append(createRoundResultView(racingCars, racingMap));
                viewBuilder.append(NEWLINE);
            }

            this.view = viewBuilder.toString();
        }

        private String createRoundView(final Snapshot snapshot) {
            return ROUND_ANNOUNCEMENT + " " + (snapshot.getNumber() + 1);
        }

        private String createRoundResultView(final List<RacingCar> racingCars, final RacingMap racingMap) {
            final StringBuilder roundResultViewBuilder = new StringBuilder();
            for (RacingCar racingCar : racingCars) {
                final int racingCarId = racingCar.getId();
                final int position = racingMap.findPosition(racingCarId);
                roundResultViewBuilder.append(createMoveView(position));
                roundResultViewBuilder.append(NEWLINE);
            }
            return roundResultViewBuilder.toString();
        }

        private String createMoveView(final int position) {
            return createMovingDistanceView(position);
        }

        private String createMovingDistanceView(final int position) {
            final StringBuilder movingDistanceViewBuilder = new StringBuilder();
            for (int i = 0; i < position; i++) {
                movingDistanceViewBuilder.append(MOVE_CHAR);
            }
            return movingDistanceViewBuilder.toString();
        }

        @Override
        public String toString() {
            return view;
        }
    }
}
