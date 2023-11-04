package car_racing.ui;

import car_racing.Track;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private Integer carCount;
    private Integer movingCount;

    private InputView(Integer carCount, Integer movingCount) {
        this.carCount = carCount;
        this.movingCount = movingCount;
    }

    public static InputView input() {
        return new InputView(inputCarCount(), inputMovingCount());
    }

    private static Integer inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return parseInt(SCANNER.nextLine());
    }

    private static Integer inputMovingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return parseInt(SCANNER.nextLine());
    }

    public Track toTrack() {
        return new Track(carCount);
    }

    public Integer getMovingCount() {
        return movingCount;
    }
}
