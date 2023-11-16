package study.racingCar;

import java.util.ArrayList;

import static study.racingCar.RandomNumGenerator.getRandomNum;

public class CarRacingGame {

    private ArrayList<Car> theWinners;

    public CarRacingGame() {
        this.theWinners = new ArrayList<>();
    }

    public void playGame(int tryCount, Car[] cars){
        for (int i = 0; i < tryCount; i++) {
            roundGameResult(cars);
            System.out.println();
        }
        Car winner = getTheWinner(cars);
        getTheWinners(cars, winner);
        printWinners();
    }

    private void printWinners(){
        System.out.print("승자:: ");
        for (Car theWinner : theWinners) {
            theWinner.printName();
        }
    }

    private void getTheWinners(Car[] cars, Car winner){
        for (Car car : cars) {
            if (car.isSamePosition(winner)){
                this.theWinners.add(car);
            }
        }
    }

    private Car getTheWinner(Car[] cars){
        Car theWinner = cars[0];
        for (Car car : cars) {
            theWinner = car.getTheWinner(theWinner);
        }
        return theWinner;
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
