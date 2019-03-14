package racing.view;

import java.util.Arrays;
import java.util.List;

public class RacingRequestView {
    private List<String> carNames;
    private int gameCount;

    public RacingRequestView(String carNames, int gameCount) {
        this.carNames = Arrays.asList(carNames.split(","));;
        this.gameCount = gameCount;
    }

    public String getCarName(int index) {
        return carNames.get(index);
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCarCount() {
        return carNames.size();
    }
}
