package car.views;


import car.domain.Car;
import car.service.CarService;
import car.service.WinnerService;

import java.util.List;
import java.util.Scanner;

public class IoMain {
    private static Scanner sc = new Scanner(System.in);
    private static final String REPLACE_ALL = "[\\[\\]]";
    private static final String MARK = "-";
    private static final String SPLITER = ",";

    public static void main(String[] args) {
        //pobi,crong,honux
        String[] names = carNamesIO();
        List<Car> cars = CarService.generate(names);
        int moveCount = moveIO();

        System.out.println("\n실행 결과");

        for (int i = 0; i < moveCount; i++) {
            CarService.repeatMove(cars);
            printMark(cars);
        }

        printChampion(cars);

    }

    public static String[] carNamesIO() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return splitNames(sc.nextLine());
    }

    public static int moveIO() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

    public static String[] splitNames(String ioName) {
        return ioName.split(SPLITER);
    }

    public static void printMark(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + MARK.repeat(car.getCarPosition()));
        }
        System.out.println();
    }

    public static String winnersString(List<Car> cars) {
        WinnerService win = new WinnerService(cars);

        List<String> winnersName = win.winnersNameList();

        return winnersName.toString().replaceAll(REPLACE_ALL, "");
    }

    public static void printChampion(List<Car> cars) {
        String champion = winnersString(cars);

        System.out.println(champion + "가 최종 우승했습니다.");
    }

}
