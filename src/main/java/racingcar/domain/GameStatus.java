package racingcar.domain;

public class GameStatus {

    private static StringBuilder racingStatus = new StringBuilder();

    public static void setStatus(String currentStatus) {
        racingStatus.append(currentStatus);
    }

    public static StringBuilder getRacingStatus() {
        return racingStatus;
    }
}
