public class Game {
    private static Computer computer;
    private static UI ui;
    private static int gameCount;

    public static void setup(){
        GameSettings settings = new GameSettings();
        Cars cars = settings.getCars();
        computer = new Computer(cars);
        ui = new UI(cars);
        gameCount = settings.getGameCount();
    }

    public static void game(){
        for (int i = 0; i < gameCount; i++) {
            computer.play();
            ui.printGameResult();
        }
    }

    public static void gameOver(){
        ui.printWinner();
        System.exit(0);
    }
}
