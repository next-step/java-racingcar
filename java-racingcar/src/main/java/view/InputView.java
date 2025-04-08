package view;

import domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final Scanner scanner = new Scanner(System.in);


    public static int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(scanner.nextLine().split(",")) // 쉼표 기준으로 분리
                .map(String::trim) // 앞뒤 공백 제거
                .peek(InputView::validateCarName) // 자동차 이름 검증
                .collect(Collectors.toList());

    }

    private static void validateCarName(String name) {

        Car.validateCarName(name);

    }


    public static int getNumberOfRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}

