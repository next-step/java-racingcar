package carrace.view;

import carrace.common.Vehicle;

import java.util.Arrays;

// 기존 Race에서 출력 로직
public class OutputView {

    public OutputView() {}

    // 상태 출력
    public void printCurrentState(Vehicle[] vehicles) {
        if (vehicles == null || vehicles.length <= 1) {
            throw new RuntimeException("자동차 대수는 2 이상의 값이어야합니다.");
        }

        Arrays.stream(vehicles)
                .forEach(
                        car ->
                                System.out.println(
                                        car.getCarName() + ": " + car.getCurrentPosition()));
        System.out.println();
    }

    // 우승자 출력
    public void printWinner(String winners) {
        if (winners.isEmpty()) {
            throw new RuntimeException("우승자가 빈 문자열이어서는 안됩니다.");
        }
        System.out.println("최종 우승자는 " + winners + " 입니다.");
    }
}
