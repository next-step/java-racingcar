package client;

import car.Car;
import carracingfield.CarRacingField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import winnerstrategy.MaxPositionDuplicateWinnerStrategy;

public class CarRacingGame {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.nextLine();
        String[] carNames = inputName.split(",");
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        System.out.println("\n실행 결과");
        CarRacingField carRacingField = new CarRacingField(
            Arrays.asList(carNames),
            new MaxPositionDuplicateWinnerStrategy()
        );
        carRacingField.moveCarsByCount(count);
        String winnerString = carRacingField.getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winnerString + "가 최종 우승했습니다.");
    }

}
