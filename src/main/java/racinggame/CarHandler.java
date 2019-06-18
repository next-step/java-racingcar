package racinggame;

import com.google.common.base.Preconditions;

public class CarHandler {
    public static final int MIN_RANDOM_INTEGER = 0;
    public static final int MAX_RANDOM_INTEGER = 10;
    public static final int MIN_MOVE_NUMBER = 4;

    static boolean isMoveCondition(int number) {
        Preconditions.checkArgument(
                number >= MIN_RANDOM_INTEGER && number <= MAX_RANDOM_INTEGER,
                "숫자의 범위는 [" + MIN_RANDOM_INTEGER + " ~ " + MAX_RANDOM_INTEGER + "] 입니다."
        );
        return number >= MIN_MOVE_NUMBER;
    }

    /*
    주신 피드백처럼 인자로 받으려고 했으나, 아래 moveAllCars 메서드에서 getRandomMoveCondition 을
    호출하기 때문에 그 위치에서 인자로 넣어주기 애매해서 RacingGameParameters 에 추가를 하여 구현했는데 괜찮은 방법인지 모르겠습니다.
     */
    public static boolean getRandomMoveCondition() {
        int ruleNumber = RacingGameParameters.getNumberGenerator().generate();
        return isMoveCondition(ruleNumber);
    }

    public static void moveAllCars(Cars cars) {
        for (Car car : cars.getCars()) {
            if (CarHandler.getRandomMoveCondition()) {
                car.move();
            }
        }
    }
}
