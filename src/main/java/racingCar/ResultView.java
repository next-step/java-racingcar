package racingCar;

public class ResultView {

    public void resultOfCars(Cars cars){
        RandomNumber randomNumber = new RandomNumber();
        for (int i=0; i<cars.carsSize(); i++) {
            System.out.println(cars.carMakeNameAndPosition(i));
            int temporaryRandomNumber = randomNumber.createRandomNumber();
            cars.carMove(i, temporaryRandomNumber);
        }
        Winners.findWinners(cars);
        System.out.println("");
    }

    public void resultOfWinners(Cars cars){
        System.out.println(Winners.winnersNameList(cars)+"가 최종 우승했습니다.");
    }

}
