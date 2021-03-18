package carRacing.view;

import carRacing.domain.Car;
import carRacing.dto.UserInput;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {

    public UserInput getUserInput() {
        Scanner staff = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String unparsedNameOfCars = staff.next("[a-zA-Z0-9,]+");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRace = staff.nextInt();
        return new UserInput(unparsedNameOfCars, numberOfRace);
    }

    public void declareRace() {
        System.out.println("\n실행 결과");
    }

    public void printWinners(List<String> winners) {
        StringBuilder mergedList = new StringBuilder();
        mergedList.append(winners.get(0));
        for (int idx = 1; idx < winners.size(); idx++) {
            mergedList.append(",").append(winners.get(idx));
        }
        System.out.println(mergedList + "가 최종 우승했습니다.");
    }

    public String generateTrace(Car car, int raceCount) {
        StringBuilder trace = new StringBuilder(car.getName() + " : ");
        for (int count = 0; count < car.getHistory().get(raceCount); count++) {
            trace.append("-");
        }
        return trace.toString();
    }

    public void printHistory(List<Car> cars) {
        for (int gameCount = 0; gameCount < cars.get(0).getHistorySize(); gameCount++) {
            printScoreboard(cars, gameCount);
        }
    }

    private void printScoreboard(List<Car> cars, int raceCount) {
        String scoreboard = cars.stream()
                .map(car -> generateTrace(car, raceCount) + "\n")
                .collect(Collectors.joining());
        System.out.println(scoreboard);
    }
}
