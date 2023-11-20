package racing;

import racing.domain.Car;
import racing.generator.NumberGenerator;
import racing.generator.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList = new ArrayList<>();
    private NumberGenerator numberGenerator = new RandomGenerator();

    public Racing(int carCount){
        for(int i=0; i<carCount; i++){
            carList.add(new Car());
        }
    }

    public Racing(String[] carNames){
        for(String name : carNames){
            carList.add(new Car(name));
        }
    }
  
    public void roundStart(){
        for(Car car : carList){
            car.turn(numberGenerator);
        }
    }

    public List<Car> getCarList(){
        return this.carList;
    }
}
