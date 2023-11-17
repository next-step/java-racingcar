package study.racingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static study.racingCar.RandomNumGenerator.getRandomNum;

public class CarRacingGame {

    public CarRacingGame() {
    }

    public void playGame(int tryCount, Car[] cars){
        for (int i = 0; i < tryCount; i++) {
            roundGameResult(cars);
            System.out.println();
        }
        Winner theWinner = new Winner();
        printWinners(theWinner.createWinners(cars, theWinner.findTheWinner(cars)));
    }

    private void printWinners(ArrayList<Car> theWinners){
        System.out.print("우승자:: ");
        for (Car theWinner : theWinners) {
            theWinner.printName();
            System.out.println(" ");
        }
    }

    private void roundGameResult(Car[] cars){
        ResultView resultView = new ResultView();
        for (Car car : cars) {
            car.move(getRandomNum());
            resultView.printRoundResult(car);
        }
    }

    public Car[] createCarList(String carName){
        String[] carNames = nameSplit(carName);
        Car[] cars = new Car[carNames.length];
        for (int i=0; i<carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }


    public String[] nameSplit(String names){
        String[] carNames = names.split(",");
        for (String name : carNames) {
            checkNameLength(name);
        }
        return carNames;
    }


    public void checkNameLength(String name){
        if (name.length() > 5){
            System.out.println("차량 이름의 글자가 5자를 초과했습니다.");
            throw new IllegalArgumentException();
        }
    }

}
