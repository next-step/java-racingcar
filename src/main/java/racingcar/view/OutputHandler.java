package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputHandler {

    public static void displayDash(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            String dash = new String(new char[car.getPosition()]).replace("\0", "-");
            System.out.printf("%s : %s%n", name, dash);
        }
        System.out.println("");
    }

    public static void racingResult(String winners) {
        System.out.println("최종 우승자: " + winners);
    }

    public static void exitMessage() {
        System.out.println("자동차 이름은 6글자를 넘을 수 없습니다.");
    }

}
