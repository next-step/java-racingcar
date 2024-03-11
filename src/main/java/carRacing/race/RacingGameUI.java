package carRacing.race;

import carRacing.car.Cars;

import java.util.Scanner;

public class RacingGameUI {
    private static final String TRACK_SYMBOL = "-";

    public String askCarsNames(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        scanner.close();
        return scanner.nextLine();
    }

    public int askTrialCount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        scanner.close();
        return scanner.nextInt();
    }
    public void printTrack(Cars cars, int trialCount) {
        System.out.println((trialCount + 1) + "회차 이동");
        cars.forEach(car -> {
            System.out.print(car.getName()+" : ");
            for (int track = 0; track < car.getPosition(); track++) {
                System.out.print(TRACK_SYMBOL);
            }
            System.out.println();
        });
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
