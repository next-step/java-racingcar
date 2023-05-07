package racingcar.view;

import calculator.StringParser;
import racingcar.domain.game.dto.CarDto;
import racingcar.domain.game.dto.CarsDto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConsoleView {
    private static final int INVALID_INPUT_LIMIT = 3;
    private final StringParser<String> nameParser;

    public ConsoleView(StringParser<String> nameParser) {
        this.nameParser = nameParser;
    }

    public void printCarsLocation(CarsDto cars) {
        for (CarDto car : cars.getCars()) {
            printCarsLocation(car);
        }
        System.out.println();
    }

    private void printCarsLocation(CarDto car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public List<String> namesOfCar() {
        return tryPrintAndGet(this::printAndGetNamesOfCar);
    }

    public int numbOfTrial() {
        return tryPrintAndGet(this::printAndGetNumbOfTrial);
    }

    private <T> T tryPrintAndGet(Supplier<T> printAndGetInput) {
        int numbOfInput = 0;

        while (numbOfInput < INVALID_INPUT_LIMIT) {
            numbOfInput++;

            try {
                return printAndGetInput.get();
            } catch (PositiveNumberException ex) {
                System.out.println("양수인 정수를 입력해 주세요");
            }
        }

        throw new RuntimeException("유효하지 않은 입력 횟수 를 초과했습니다");
    }

    private int printAndGetNumbOfTrial() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return tryGetInteger();
    }

    private int tryGetInteger() {
        try {
            return getPositiveNumberInput();
        } catch (InputMismatchException ex) {
            throw new PositiveNumberException(ex);
        }
    }

    private int getPositiveNumberInput() {
        Scanner scanner = new Scanner(System.in);

        int numb = scanner.nextInt();

        if (numb < 0) {
            throw new PositiveNumberException("양수가 아닙니다");
        }

        return numb;
    }


    private List<String> printAndGetNamesOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return Arrays.stream(nameParser.parse(getString()))
                .collect(Collectors.toList());
    }

    private String getString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public void printWinners(CarsDto winners) {
        String winnerNames = winners.getCars().stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
