package step4;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final int BETWEEN_ZERO_AND_NINE = 10;
    private static final int CONDITION = 4;
    private static Random random = new Random();

    public void racingRound(Position position, List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            moveOrStop(position, names.get(i));
        }
    }

    private void moveOrStop(Position position, String name) {
        if(isSatisfiedConditionForMove(getRandomNum())) {
            position.move(name);
        }
    }

    public int getRandomNum() {
       return random.nextInt(BETWEEN_ZERO_AND_NINE);
    }

    public boolean isSatisfiedConditionForMove(int randomNumber) {
        return randomNumber >= CONDITION;
    }
}
