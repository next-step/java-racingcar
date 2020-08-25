package step4.view;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.Scanner;

public class RacingCar {

    Cars cars = new Cars();

    private void init(String value) {
        String[] list = value.split(",");

        for(int i = 0 ; i < list.length ; i ++) {
            cars.add(new Car(list[i]));
        }
    }

    public void run(String value, int number) {
        for(int i = 0; i < number ; i ++){
            cars.run();
        }

        printWinner(cars);
    }

    private void printWinner(Cars cars){
        System.out.println(cars.printWinner()+"가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String value = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = scanner.nextInt();

        RacingCar racingCar = new RacingCar();

        racingCar.run(value, number);
    }
}
