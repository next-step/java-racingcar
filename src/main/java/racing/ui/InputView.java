package racing.ui;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String ASK_NUMBER_OF_TRYS = "시도할 회수는 몇 회 인가요?";
    private static final String SPLIT_PATTERN = ", *";

    private static InputView instance;
    private static Scanner scanner;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
            scanner = new Scanner(System.in);
        }
        return instance;
    }

    public int getNumCars() {
        System.out.println(ASK_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int getNumMoves() {
        System.out.println(ASK_NUMBER_OF_TRYS);
        return scanner.nextInt();
    }

    public List<String> getNameOfCars() {
        System.out.println(ASK_NAME_OF_CARS);
        String s = scanner.nextLine();
        return split(s);
    }

    private List<String> split(String s) {
        if (s == null || s.isBlank()) {
            return Collections.emptyList();
        }
        return List.of(s.split(SPLIT_PATTERN));
    }
}
