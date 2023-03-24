package racing;

import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingGame {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String drivers = getDriversName();
        int round = getRound();

        RaceControll raceControll = new RaceControll(drivers);
        race(round, raceControll);

        String winners = raceControll.getWinners()
                        .stream().map(Driver::getName)
                        .collect(Collectors.joining(", "));
        System.out.println(String.format("최종 우승자 : %s", winners));
    }

    private static String getDriversName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static int getRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    private static void race(int round, RaceControll raceControll) {
        System.out.println("실행 결과");
        for(int i = 0; i < round; i++) {
            raceControll.raceSingleRound();
            raceControll.getCars()
                    .stream()
                        .map(RacingCar::printPosition)
                            .forEach(System.out::println);
            System.out.println();
        }
    }
}
