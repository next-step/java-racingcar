package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing implements RandomNumber{

    public static final String CANNOT_BE_NEGATIVE_NUMBERS = "음수 입력 불가능합니다.";

    public List<List<Integer>> racingGame(int carCount, int tryCount){

        validation(carCount, tryCount);

        Cars carList = new Cars();

        List<List<Integer>> viewList = new ArrayList<>();

        makeCarList(carCount, carList);

        racingStart(tryCount, carList, viewList);

        return viewList;
    }

    private static void validation(int carCount, int tryCount) {
        if(carCount < 0 || tryCount < 0){
            throw new RuntimeException(CANNOT_BE_NEGATIVE_NUMBERS);
        }
    }

    private void racingStart(int tryCount, Cars carList, List<List<Integer>> viewList) {
        for(int i = 0; i< tryCount; i++){
            List<Integer> resultList = carRacing(carList);
            listAddToMoveCount(carList, resultList);
            viewList.add(resultList);
        }
    }

    private void listAddToMoveCount(Cars carList, List<Integer> resultList) {
        for(Car car : carList.carList){
            resultList.add(car.getMoveCount());
        }
    }

    private List<Integer> carRacing(Cars carList) {
        List<Integer> resultList = new ArrayList<>();
        moveOrStop(carList);
        return resultList;
    }

    private void moveOrStop(Cars carList) {
        for(int j = 0; j< carList.getSize(); j++){
            Car car = carList.getCar(j);
            car.moveCar(randomNumber());
        }
    }

    private void makeCarList(int carCount, Cars carList) {
        for(int i = 0; i< carCount; i++){
            carList.addCar(new Car());
        }
    }

    public int randomNumber(){
        return random.nextInt(10);
    }

}
