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
    private int DEFAULT_MAX_POSITION = 0;

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

        int maxPosition = getMaxPosition(racingCars);

        List<String> winners = printWinner(maxPosition);
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

    // 최종우승자 리스트로 리턴
    private List<String> printWinner(int maxPosition){
        return racingCars.stream().filter(car->car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }


    // 제일 많이 움직인 포지션 리턴
    private int getMaxPosition(List<Car> cars ){
        cars.stream().map(Car::getPosition).filter(position->position > DEFAULT_MAX_POSITION).forEach(position-> DEFAULT_MAX_POSITION = position); //  최고 맥스값 선정
        return DEFAULT_MAX_POSITION;
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
