package champion;

import java.util.List;
import java.util.Scanner;

import static champion.CarService.*;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static String[] carNamesIO() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return splitNames(sc.nextLine());
    }

    public static int moveIO() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

    public static String[] splitNames(String ioName) {
        return ioName.split(",");
    }

    public static void printMark(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.carName() + " : " + "-".repeat(car.currentPosition()));
        }
        System.out.println();
    }

    public static String getChampionString(List<Car> cars) {
        List<String> list = winChampionList(cars);

        return list.toString().replaceAll("[\\[\\]]", "");
    }

    public static void printChampion(List<Car> cars) {
        String champion = getChampionString(cars);

        System.out.println(champion + "가 최종 우승했습니다.");
    }
}
