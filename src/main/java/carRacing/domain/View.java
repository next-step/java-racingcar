package carRacing.domain;

import carRacing.dto.UserInput;

import java.util.List;
import java.util.Scanner;

public class View {

    public UserInput getUserInput(){
        Scanner staff = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = staff.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRace = staff.nextInt();
        return new UserInput(numberOfCars, numberOfRace);
    }

    public void printScoreboard(List<Car> cars){
        System.out.println("=========SCOREBOARD=========");
        cars.forEach(System.out::println);
        System.out.println();
    }
}
