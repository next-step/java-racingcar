package racegame;

import java.util.List;
import java.util.Scanner;

public class CarView {
    public static String[] inputNameList() {
        System.out.println("카 이름을 적어주세요 ,로 구분 가능합니다.");
        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();

        return names.split(",");
    }

    public static int inputGameCount() {
        System.out.println("게임 횟수를 입력해주세요");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void carPrint(List<Car> carList) {
        for (Car car : carList) {
            carCheckGoStep(car);
        }
        System.out.println("");
    }

    private static void carCheckGoStep(Car car) {
        String print = "";
        for (int i = 0; i < car.getGoStep(); i++) {
            print += "-";
        }
        System.out.println(car.getName() + "" + print);
    }

    public void winnerPrint(List<Car> carList) {
        StringBuilder winnerBuilder = new StringBuilder();
        for (Car car : carList) {
            winnerBuilder.append(car.getName()).append(",");
        }
        String winner = winnerBuilder.toString();
        winner = winner.substring(0, winner.length() - 1);
        System.out.println("승자는 " + winner + "입니다.");
    }
}
