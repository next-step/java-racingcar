public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.playGame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
