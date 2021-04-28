package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RacingCar racingCar = new RacingCar();

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        racingCar.nameCheck(carName);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        String[] carNameArr = carName.split(",");

        for (int i = 0; i < carNameArr.length; i++) {

            carNameArr[i] += " : ";
        }

        for (int i = 0; i < count; i++) {

            for (int j = 0; j < carNameArr.length; j++) {

                carNameArr[j] += racingCar.condition();
                System.out.println(carNameArr[j]);
            }
            System.out.println();
        }

        List<String> winner = new ArrayList<String>();
        int maxlenth = 0;

        for (int i = 0; i < carNameArr.length; i++) {

            if (carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length() >
                    maxlenth) {

                maxlenth = carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length();
            }
        }

        for (int i = 0; i < carNameArr.length; i++) {

            if (maxlenth == carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length()) {

                winner.add(carNameArr[i]);
            }
        }

        System.out.println("최종 우승자: " + winner.toString().replaceAll("\\]", "").replaceAll("\\[", "")
                .replaceAll(":", "").replaceAll("-", "").replaceAll("  ,", ","));
    }
}
