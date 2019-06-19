package edu.nextstep.racing.view;

import edu.nextstep.racing.utils.ValidationUtils;
import edu.nextstep.racing.utils.ViewUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 21:17
 */
public class InputView {

    private Scanner scanner = new Scanner(System.in);

    private static final String SPLIT_CAR_SEPERATOR = ",";

    public List<String> getNameOfCars() {
        ViewUtils.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();

        ValidationUtils.checkNull(cars);

        return Arrays.asList(splitCars(cars));
    }

    public int getNumberOfTime() {
        ViewUtils.printMessage("시도할 회수는 몇회인가요.");
        int time = Integer.parseInt(scanner.nextLine());

        ValidationUtils.checkNull(time);

        return time;
    }

    public String[] splitCars(String cars) {
        return cars.split(SPLIT_CAR_SEPERATOR);
    }
}
