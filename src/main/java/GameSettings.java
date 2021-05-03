import java.util.Arrays;

public class GameSettings {
    private Cars cars;
    private int gameCount;

    public GameSettings() {
        setCars();
        setGameCount();
    }

    private void setCars() {
        cars = new Cars();
        String names = UI.answer(UIMessage.ASK_CAR_NAME);
        cars.setCarsByNames(Arrays.asList(names.split(",")));
    }

    private void setGameCount() {
        gameCount = Integer.valueOf(UI.answer(UIMessage.ASK_BETTING_COUNT));
    }

    public Cars getCars() {
        return cars;
    }

    public int getGameCount() {
        return gameCount;
    }
}
