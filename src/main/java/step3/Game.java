package step3;

public class Game {

    private final Integer time;
    private final Names names;
    private final MoveStrategy moveStrategy;
    private Cars cars;
    private final GameHistory gameHistory = new GameHistory();

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
            addHistory(now);
        }
        saveWinner();
    }

    private void saveWinner() {
        gameHistory.saveWinner(cars.getWinner());
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

    private void addHistory(Integer now) {
        gameHistory.save(now, cars);
    }

    private void makeCars() {
        cars = Cars.createWithDefaultPosition(moveStrategy, names);
    }

    private void step() {
        this.cars = this.cars.move();
    }
}
