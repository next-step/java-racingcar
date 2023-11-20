package study.racingCar;

import java.util.ArrayList;
import java.util.List;

import static study.racingCar.RandomNumGenerator.getRandomNum;

public class CarRacingGame {


    public CarRacingGame() {
    }

    public void playGame(int tryCount, List<Car> cars){
        for (int i = 0; i < tryCount; i++) {
            roundGameResult(cars);
            System.out.println();
        }
        Winner theWinner = new Winner();
        printWinners(theWinner.createWinners(cars, theWinner.findTheWinner(cars)));
    }

    private void printWinners(List<Car> theWinners){
        System.out.print("우승자:: ");
        for (Car theWinner : theWinners) {
            theWinner.printName();
            System.out.println(" ");
        }
    }

    private void roundGameResult(List<Car> cars){
        ResultView resultView = new ResultView();
        for (Car car : cars) {
            car.move(getRandomNum());
            resultView.printRoundResult(car);
        }
    }

    public List<Car> createCarList(String carName){
        String[] carNames = nameSplit(carName);
        List<Car> cars = new ArrayList<Car>();
        for (String name : carNames) {
            cars.add(new Car(name));
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
