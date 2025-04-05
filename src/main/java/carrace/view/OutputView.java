package carrace.view;

import carrace.vehicle.Vehicles;

import java.util.Arrays;
import java.util.List;

// 기존 Race에서 출력 로직
public class OutputView {

    public OutputView() {}

    // 상태 출력
    public void printCurrentState(Vehicles vehicles) {
        Arrays.stream(vehicles.getVehicles())
                .forEach(
                        car ->
                                System.out.println(
                                        car.getCarName() + ": " + car.getCurrentPosition()));
        System.out.println();
    }

    // 우승자 출력
    public void printWinner(List<String> winners) {
        if (winners.isEmpty()) {
            throw new RuntimeException("하나 이상의 우승자가 있어야합니다.");
        }
        System.out.println("최종 우승자는 " + String.join(",", winners) + " 입니다.");
    }
}
