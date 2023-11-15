package study.racingCar;

public class CarRacingGame {

    public CarRacingGame() {
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
