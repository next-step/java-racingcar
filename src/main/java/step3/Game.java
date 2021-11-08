package step3;

public class Game {
//
//    private final Integer time;
//    private final Names names;
//    private final MoveStrategy moveStrategy;
//    private final List<Car> cars = new ArrayList<>();
//    private final GameHistory gameHistory = new GameHistory();
//
//    private Game(Names names, Integer time, MoveStrategy moveStrategy) {
//        this.time = time;
//        this.names = names;
//        this.moveStrategy = moveStrategy;
//    }
//
//    public static Game of(GameInformation gameInformation, MoveStrategy moveStrategy) {
//        return new Game(gameInformation.getNames(), gameInformation.getTime(), moveStrategy);
//    }
//
//    public void start() {
//        addCar();
//        for (int now = 0; now < this.time; now++) {
//            step();
//            addHistory(now);
//        }
//    }
//
//    public GameHistory getGameHistory() {
//        return gameHistory;
//    }
//
//    private void addHistory(Integer now) {
//        List<Position> log = getLog();
//        gameHistory.save(now, log);
//    }
//
//    private List<Position> getLog() {
//        return this.cars.stream()
//                .map(Car::getPosition)
//                .collect(Collectors.toList());
//    }
//
//    private void addCar() {
//        names.getNames().stream().forEach(name -> cars.add(Car.createWithDefaultPosition(moveStrategy, name)));
//    }
//
//    private void step() {
//        this.cars = this.cars.stream()
//                .map(Car::moveOrStop)
//                .collect(Collectors.toList());
//    }
}
