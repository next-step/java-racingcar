package step4;

public class Game {

    private final Integer time;
    private final Names names;
    private final MoveStrategy moveStrategy;
    private final GameHistory gameHistory = new GameHistory();
    private Cars cars;

    private Game(Names names, Integer time, MoveStrategy moveStrategy) {
        this.time = time;
        this.names = names;
        this.moveStrategy = moveStrategy;
    }

    public static Game of(GameInformation gameInformation, MoveStrategy moveStrategy) {
        return new Game(gameInformation.getNames(), gameInformation.getTime(), moveStrategy);
    }

    public void start() {
        makeCars();
        for (int now = 0; now < this.time; now++) {
            step();
            gameHistory.save(now, cars);
        }
        gameHistory.saveWinner(cars.getWinner());
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

    private void makeCars() {
        cars = Cars.createWithDefaultPosition(names);
    }

    private void step() {
        this.cars = this.cars.move(moveStrategy);
    }
}
