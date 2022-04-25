package racingversion2.view;

import java.util.Scanner;
import racingversion2.car.CarName;

public class InputView {

    private static final String INSERT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MANY_TRIES_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public CarName[] settingCarNames() {
        System.out.println(INSERT_CAR_NAMES_MESSAGE);
        return splitCarName(scanner.nextLine());
    }

    public int settingTryCount() {
        System.out.println(HOW_MANY_TRIES_MESSAGE);
        return scanner.nextInt();
    }

    private CarName[] splitCarName(String carNames) {
        String[] nameArray = carNames.split(",");
        CarName[] carNameArray = new CarName[nameArray.length];
        for (int i = 0; i < nameArray.length; i++) {
            carNameArray[i] = CarName.of(nameArray[i]);
        }
        return carNameArray;
    }
}
