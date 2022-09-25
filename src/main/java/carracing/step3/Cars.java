package carracing.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<StringBuilder> carsMoveTrace;

    public Cars(int carCount) {
        carsMoveTrace = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            carsMoveTrace.add(new StringBuilder());
        }
    }

    public void moveAllCarsRandomly() {
        for (int i = 0; i < carsMoveTrace.size(); i++) {
            moveCarRandomly(i);
        }
    }

    private void moveCarRandomly(int carNum) {
        final int MOVE_FORWARD_BORDER = 4;
        final int RANDOM_NUMBER_SCOPE = 10;

        int randomNumber = new Random().nextInt(RANDOM_NUMBER_SCOPE);
        if (randomNumber > MOVE_FORWARD_BORDER) {
            carsMoveTrace.get(carNum).append("-");
        }
    }

    public String getAllCarsTrace() {
        StringBuilder allCarTrace = new StringBuilder();
        for (StringBuilder carMoveTrace : carsMoveTrace) {
            allCarTrace.append(carMoveTrace.toString()).append("\n");
        }
        allCarTrace.append("\n");
        return allCarTrace.toString();
    }

}
