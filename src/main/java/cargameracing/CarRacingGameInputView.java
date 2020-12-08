package cargameracing;

import java.util.Scanner;

/**
 * View Role
 * @author minji
 */
public class CarRacingGameInputView {
    int carCount;
    int playCount;

    CarRacingGameInputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String value = scanner.nextLine();
        int carCount = Integer.parseInt(value);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCount = scanner.nextInt();
        this.carCount = carCount;
        this.playCount = playCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getPlayCount() {
        return playCount;
    }

}
