package racing.domain;


public class Racing {

    private final String CANNOT_BE_NEGATIVE_NUMBERS = "음수 입력 불가능합니다.";

    private int carCount = 0;

    private int tryCount = 0;

    private Cars carList = new Cars();

    public Racing(int carCount, int tryCount){
        this.carCount = carCount;
        this.tryCount = tryCount;
        makeCarList(carCount);
    }

    private void makeCarList(int carCount) {
        for(int i = 0; i< carCount; i++){
            carList.addCar(new Car());
        }
    }

    public Cars racingStart(int i, int randomNumber){
        validation(carCount, tryCount);
        Car car = carList.getCar(i);
        car.moveCar(randomNumber);
        return carList;
    }

    private void validation(int carCount, int tryCount) {
        if(carCount < 0 || tryCount < 0){
            throw new RuntimeException(CANNOT_BE_NEGATIVE_NUMBERS);
        }
    }

    public Cars getCars(){
        return carList;
    }
}
