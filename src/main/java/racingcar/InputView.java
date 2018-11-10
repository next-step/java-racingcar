package racingcar;

import java.util.Scanner;

public class InputView {

    public static String getCarsNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsNames = sc.nextLine();

        return carsNames;
    }

    public static int getRacingTracks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int racingTracks = sc.nextInt();

        return racingTracks;
    }
}
