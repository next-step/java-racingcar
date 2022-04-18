package racing_game.domain;

import racing_game.util.Behavior;
import racing_game.util.GameRole;

public class RacingCar {

    private final String name;

    public RacingCar(String name) {
        this.checkName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Behavior stopOrForward(int roundResult) {
        return GameRole.checkRoundResult(roundResult);
    }

    private void checkName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("레이킹 카의 이름은 5자를 넘을 수 없습니다.");
        }
    }
}
