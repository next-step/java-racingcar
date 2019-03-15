package game;

public class GameFactory {
    public static Game createGame(GameType gameType){
        if(gameType == GameType.CONSOLE){
            return new ConsoleGame();
        }

        throw new IllegalArgumentException("invalid game type");
    }
}
