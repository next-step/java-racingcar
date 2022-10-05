package step4;

import java.util.List;

public class OutputRacingCar {

    public void printRound(Cars cars) {
        for (int i = 0 ; i < cars.getCarsSize() ; i++) {
            Car car = cars.getCar(i);
            System.out.println(car.getName() + " : " + printBar(car.getPosition()));
        }
        System.out.println();
    }

    private String printBar(int value) {
        String result = "";
        for (int i = 0 ; i < value ; i++) {
            result += "-";
        }
        return result;
    }

    public void printResult(List<String> winners) {
        System.out.print(String.join(", ", winners) + "가 최종 우승했습니다.");
    }


    public void printTitle() {
        System.out.println("\n실행 결과");
    }
}
