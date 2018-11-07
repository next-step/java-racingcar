package rcgame.ui;

import rcgame.domain.RcCar;
import rcgame.dto.RcGameRequest;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUI {

    public static RcGameRequest getRcGameRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)?");
        String[] rcCarName = scanner.nextLine().split(",");;


        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RcGameRequest(rcCarName, time);
    }

    public static void printRcCarPositions(List<RcCar> rcCars) {
        rcCars.forEach(rcCar ->
                positionGrid(rcCar));
        System.out.println();
    }

    private static void positionGrid(RcCar rcCar) {
        String str = "";
        str += printNameTag(rcCar);

        for(int i=0; i < rcCar.getPosition(); i++){
            str += "-";
        }

        System.out.println(str);
    }

    private static String printNameTag(RcCar rcCar) {
        return rcCar.getName().concat(" : ");
    }

    public static void printProgressNotice() {
        System.out.println("\n");
        System.out.println("실행결과");
    }

    public static void printWinnerNotice(List<RcCar> rcCars) {
        String winnerNotice = rcCars.stream()
                .map(rcCar -> rcCar.getName())
                .collect(Collectors.joining(","))
                .concat("가 최종 우승했습니다");

        System.out.println(winnerNotice);
    }

}
