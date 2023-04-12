package racingcar.view;

import racingcar.service.Car;

import java.util.List;

public class ResultView {

    public static void view(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");

        if (cars.size() == 0 || cars.get(0).getState().size() == 0) {
            System.out.println("레이스가 실행되지 않았습니다.");
            return;
        }

        int labs = cars.get(0).getState().size();
        for (int lab = 0; lab < labs; lab++) {
            for (int car = 0; car < cars.size(); car++) {
                System.out.println(cars.get(car).getName() + " : "+"-".repeat(cars.get(car).getState().get(lab)));
            }
            System.out.println();
        }
    }

    public static void viewWinners(List<Car> winners) {
        if(winners.size() == 0){
            return;
        }

        for(int car=0; car < winners.size(); car++){
            System.out.print(winners.get(car).getName());
            if(car != winners.size() -1) {
                System.out.print(", ");
            }
        }

        System.out.print("가 최종 우승했습니다.");
    }
}
