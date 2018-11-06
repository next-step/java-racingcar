package rcgame.ui;

import rcgame.dto.RcGameRequestDto;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleUI {

    public static RcGameRequestDto getRcGameRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RcGameRequestDto(carNumber, time);
    }

    public static void printRcCarPositions(List<Integer> positions) {
        positions.forEach(integer -> {
            positionGrid(integer);
        });
        System.out.println();
    }

    private static void positionGrid(Integer carPerPosition) {
        String str = "";
        for(int i=0; i < carPerPosition; i++){
            str += "-";
        }

        System.out.println(str);
    }

    public static void printResultNotice() {
        System.out.println("\n");
        System.out.println("실행결과");
    }

}
