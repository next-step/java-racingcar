package racing_car.view;

import racing_car.ErrorMessage;
import racing_car.RacingSpec;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String CAR_COUNT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String UESR_SPLIT_DELIMITER = ",";

    public static RacingSpec enterInput() {
        List<String> users = enterRacingUser();
        if (users.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_RACING_USER);
        }
        Integer lap = enterRacingLap();
        return new RacingSpec(users, lap);
    }



    private static List<String> enterRacingUser() {
        System.out.println(CAR_COUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<String> userNameString = Arrays.asList(input.split(UESR_SPLIT_DELIMITER));
        return userNameString
                .stream()
                .filter(Objects::nonNull)
                .filter(name -> name.isEmpty() == false)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static Integer enterRacingLap() {
        System.out.println(MOVE_COUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
