package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingConsoleView {

    private final Scanner scanner;

    public CarRacingConsoleView(){
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return scanner.nextLine().replace(" ", "");
    }

    public int inputRound(){
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Integer.parseInt(scanner.nextLine());
    }

    public void beforeRacing(){
        System.out.println("실행결과");
    }

    public void showRacing(List<Car> cars){
        cars.stream().forEach(
                car -> {
                    System.out.println(String.format("%s : %s", car.getName(), translatePosition(car.getPosition())));
                    System.out.println();
                });
    }

    public String translatePosition(int position){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < position; i++){
            sb.append("-");
        }

        return sb.toString();
    }

    public void showWinners(List<Car> winnerCars){
        String winnerStringFormat = winnerCars.stream()
                        .map(Car::getName)
                        .collect(Collectors.joining(", "));

        System.out.println(String.format("최종 우승자 : %s", winnerStringFormat));
    }

}
