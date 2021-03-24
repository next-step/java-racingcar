package step3;

import java.util.Scanner;

public class RacingMain {
    private static Scanner scanner = new Scanner(System.in);

    public static int getCarCount() {
        while (true) {
            System.out.println("> 자동차 대수는 몇 대 인가요?");
            int count = scanner.nextInt();
            if (count < 1) System.out.println("자동차는 1대 이상이여야 합니다. 다시 입력해주세요");
            else return count;
        }
    }

    public static int getTryCount() {
        System.out.println("> 시도할 회수는 몇회 인가요?");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        try {
            int carCount = getCarCount();
            int tryCount = getTryCount();
            System.out.println("main start... Car Count : " + carCount + "  Try Count : " + tryCount);
            new CarRacing(carCount, tryCount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
