package racing.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameRequestView {
    private List<RacingCarDto> carNames = new ArrayList();
    private int gameCount;

    public RacingGameRequestView(String[] names) {
        Arrays.stream(names).forEach(n -> this.carNames.add(new RacingCarDto(n)));
    }

    public RacingGameRequestView(String[] names, int gameCount) {
        Arrays.stream(names).forEach(n -> this.carNames.add(new RacingCarDto(n)));
        this.gameCount = gameCount;
    }

    public List<RacingCarDto> getCarNames() {
        return carNames;
    }

    public String getCarName(int index) {
        return carNames.get(index).getCarName();
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCarCount() {
        return carNames.size();
    }
}
