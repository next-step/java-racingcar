package carracing.ui;

import carracing.Track;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private final int carCount;
    private final int movingCount;

    private InputView(int carCount, int movingCount) {
        this.carCount = carCount;
        this.movingCount = movingCount;
    }

    public static InputView input() {
        return new InputView(inputCarCount(), inputMovingCount());
    }

    private static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return parseInt(SCANNER.nextLine());
    }

    private static int inputMovingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return parseInt(SCANNER.nextLine());
    }

    public Track toTrack() {
        return new Track(carCount, movingCount);
    }

    public Integer getMovingCount() {
        return movingCount;
    }
}
