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

        final int RANDOM_NUMBER_SCOPE = 10;

        int randomNumber = new Random().nextInt(RANDOM_NUMBER_SCOPE);
        if (isMovable(randomNumber)) {
            carsMoveTrace.get(carNum).append("-");
        }
    }

    private static boolean isMovable(int randomNumber) {
        final int MOVE_FORWARD_BORDER = 4;
        return randomNumber > MOVE_FORWARD_BORDER;
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
