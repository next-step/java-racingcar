package step3.car_racing.view;

import step3.car_racing.model.Racing;

import java.util.Scanner;

public class ResultView {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carSize = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = scanner.nextInt();

        System.out.println();

        System.out.println("실행결과");

        new Racing().race(carSize, racingCount);
    }


}
