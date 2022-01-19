package racingcar.domain;

public class Racing {

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public static boolean stopOrMoveForward() {
        if (generateRandomNumber() >= 4) {
            return true;
        }
        return false;
    }
}
