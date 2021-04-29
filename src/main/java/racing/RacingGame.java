package racing;

import racing.utils.ConvertString;
import racing.utils.RandomNumber;
import racing.view.Input;
import racing.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> makeCar(String name, List<Car> carList) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
        Car car = new Car(name);
        car.init();
        carList.add(car);
        return carList;
    }

    public void gameStart() {
        RacingGame racingGame = new RacingGame();
        Output output = new Output();
        Input input = new Input();
        ConvertString convertString = new ConvertString();
        List<Car> carList;

        output.start();
        String carString = input.makeCars();
        String[] carNameArray = convertString.splitString(carString);
        carList = makeCarList(carNameArray);
        moveCountChange(carList);
    }

    private List<Car> makeCarList(String[] carNameArray) {
        List<Car> carList = new ArrayList<Car>();

        for (String carName : carNameArray) {
            makeCar(carName, carList);
        }
        return carList;
    }

    private int makeRandomNumber(){
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.makeRandomNumber();
    }

    private void moveCountChange(List<Car> carList) {
        for(int i =0; i < carList.size(); i++) {
            carList.get(i).move(makeRandomNumber());
        }
    }

    private List<String> findWinner(List<Car> carList){
        List<String> winnerList = new ArrayList<>();
        int winnerCount = 0;

        for(int i =0; i < carList.size(); i++) {
            winnerCount = findWinnerCount(carList.get(i),winnerCount,winnerList);
        }
        return winnerList;
    }

    private int findWinnerCount(Car car,int winnerCount,List<String> winnerList) {
        if(car.getMoveCount() == winnerCount) {
            winnerList.add(car.getName());
        }
        if(car.getMoveCount() > winnerCount) {
            winnerList.clear();
            winnerCount = car.getMoveCount();
            winnerList.add(car.getName());
        }
        return winnerCount;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.gameStart();
    }
}