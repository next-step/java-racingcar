package step3;

import java.util.ArrayList;
import java.util.List;

/**
 * STEP3. 자동차 경주
 * 
 * 1. 입력값   : 차량 수, 이동 횟수
 * 2. 전진조건 : 0 ~ 9 사이의 난수를 발생하여 4이상인 경우
 * 
 * @author ddak-ddakong
 *
 */
public class RacingCar {
    
    private List<Car> cars;                         //차량
    private int roundCount;                         //이동 횟수
    
    public RacingCar(int carCount, int roundCount) {
        this.roundCount = roundCount;
        this.cars = new ArrayList<Car>();
        
        for( int index = 0 ; index < carCount ; index++ ) {
            this.cars.add(index, new Car());
        }
    }
    
    public int totalRound() {
        return this.roundCount;
    }
    
    public int totalCarCount() {
        return this.cars.size();
    }

    public Car carByIndex(int index) {
        return cars.get(index);
    }
    
    public void racing() {
        for( int rIndex = 0 ; rIndex < roundCount ; rIndex++ ) {
            for( int cIndex = 0 ; cIndex < totalCarCount() ; cIndex++ ) {
                carByIndex(cIndex).move();
            }
        }
    }
}    
