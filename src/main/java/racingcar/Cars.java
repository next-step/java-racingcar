package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        //아래 반복문을 메소드로 빼는게 좋을까요? 아니면 이대로 생성자 안에 둬도 괜찮은가요??
        for(int i=0; i<carCount; i++){
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(CreateRandomNumber.getRandomNumber());
        }
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car);
        }
        return winners;
    }

    private void addWinner(List<Car> winners, Car car) {
        if(car.isWinner()){
            winners.add(car);
        }
    }


}
