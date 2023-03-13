package racingcar.service;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {

    private List<Car> racingCars;
    private int totalTry;
    private int maxPosition = 0;

    public RacingCarGame(String[] carNames, int num){
        this.racingCars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
        this.totalTry = num;
    }

    public void start() {
        IntStream.range(0, totalTry)
                .forEach(i -> {
                    racingCars.forEach(Car::move);
                    printPosition();
                });
        System.out.print("우승자 :");
        List<String> winners = printWinner();
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private void printPosition() {
        racingCars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getPosition()).forEach(i -> System.out.print("-"));
            System.out.println();
        });
        System.out.println();
    }

    private List<String> printWinner(){
        racingCars.stream().map(Car::getPosition).filter(position->position > maxPosition ).forEach(position-> maxPosition = position); //  최고 맥스값 선정
        return racingCars.stream().filter(car->car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }

    public static  void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numTry = scanner.nextInt();
        scanner.close();
        RacingCarGame carGame = new RacingCarGame(carNames, numTry);
        carGame.start();
    };

}
