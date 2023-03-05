package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRacing {
    static CarRacing carRacing = new CarRacing();

    public static void main(String[] args) {

        String[] carNames;
        int racingCount;
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = scan.nextLine();
        carNames = inputString.split(",");
        if(!carRacing.checkCarNameLength(carNames)) {
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
            return;
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        racingCount = scan.nextInt();

        System.out.println("결과 : ");
        Car[] cars = carRacing.racingStart(carRacing.makeCars(carNames), racingCount);
        String winners = carRacing.whoIsWinner(cars);
        System.out.println("최종 우승자: "+winners);
    }

    private Car[] makeCars(String[] carNames) {

        Car[] cars = new Car[carNames.length];

        for(int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i], 0);
        }

        return cars;
    }

    private Car[] racingStart(Car[] cars, int racingCount){

        for(int i = 0; i < racingCount; i++) {
            carRacing.randomGo(cars);
            System.out.println("");
        }

        return cars;
    }
    private String whoIsWinner(Car[] cars) {

        ArrayList<String> winnerNames = new ArrayList();
        int bestCore = 0;

        for(int i = 0; i < cars.length; i++) {

            if(bestCore == cars[i].getCount()) {
                winnerNames.add(cars[i].getName());
                bestCore = cars[i].getCount();
            }

            if(bestCore < cars[i].getCount()) {
                winnerNames.clear();
                winnerNames.add(cars[i].getName());
                bestCore = cars[i].getCount();
            }
        }
        return String.join(",", winnerNames);
    }

    private void randomGo(Car[] cars) {
        for(int i = 0; i < cars.length; i++) {
            if(Math.random() * 10 >= 4) {
                cars[i].addCount();
            }
            carRacing.printStatus(cars[i]);
        }
    }

    private boolean checkCarNameLength(String[] carNames) {
        for(int i = 0; i < carNames.length; i++) {
            if(carNames[i].length()>5) {
                return false;
            }
        }
        return true;
    }

    private void printStatus(Car car) {
        System.out.println(car.getName() + ":" + car.getCountPrint());
    }

}


