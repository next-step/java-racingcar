package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Participants;
import racingcar.domain.car.Car;

public class UserInput {
    static Printer printer = new Printer();
    static Scanner scan = new Scanner(System.in);
    static int NAME_LENGTH = 5;

    public static Participants createCars() {
        printer.printInputCarNameMessage();
        String[] names = getInputValue().split(",");
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : names) {
                name = name.trim();
                validateCarName(name);
                Car car = Car.from(name);
                cars.add(car);
            }
        } catch (IllegalArgumentException e) {
            printer.printErrorMessage(e.getMessage());
            return createCars();
        }
        return Participants.getInstance(cars);
    }

    public static int setTurn() {
        String turn;
        try {
            printer.printInputTurnMessage();
            turn = getInputValue();
            validateTurn(turn);
        } catch (IllegalArgumentException e) {
            printer.printErrorMessage(e.getMessage());
            return setTurn();
        }
        return Integer.parseInt(turn);
    }

    public static String getInputValue() {
        return scan.nextLine().trim();
    }

    private static void validateCarName(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름이 %d자를 초과합니다.", NAME_LENGTH));
        }
    }

    private static void validateTurn(String turn) {
        if (turn.trim().equals("")) {
            throw new IllegalArgumentException("횟수를 입력해주세요.");
        } else if (!turn.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException("입력한 값은 숫자가 아닙니다.");
        } else if (Integer.parseInt(turn) < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }
}
