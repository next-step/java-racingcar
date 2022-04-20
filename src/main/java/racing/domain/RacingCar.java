package racing.domain;

import racing.util.Behavior;
import racing.util.GameRole;

public class RacingCar {

    private final Name name;

    public RacingCar(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    public Behavior stopOrForward(int roundResult) {
        return GameRole.checkRoundResult(roundResult);
    }

    public static class Name {
        private final String name;

        public Name(String name) {
            this.checkName(name);
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        private void checkName(String name) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("레이킹 카의 이름은 5자를 넘을 수 없습니다.");
            }
        }
    }
}
