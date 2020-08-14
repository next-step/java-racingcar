package pobiRacingCar.domain;

import pobiRacingCar.utils.StringUtils;
import pobiRacingCar.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static pobiRacingCar.domain.Car.MAX_BOUND;

public class RacingGame {
   private final List<Car> cars;
   private int tryNo;

   public RacingGame(String carNames, int tryNo) {
       this.cars = initCars(carNames);   //Car.getName()이 아닌, car에게 name 메시지
       this.tryNo = tryNo;
   }

   private static List<Car> initCars(String carNames) {
       if (StringUtils.isNullOrBlank(carNames)) {
           throw new IllegalArgumentException("car needs name");
       }
       String[] names = carNames.split(",");
       List<Car> cars = new ArrayList<>();
       for (String name : names) {
           if (!ValidationUtils.validName(name)) {
               throw new IllegalArgumentException("name length should be under 5");
           }
           cars.add(new Car(name)); //cars리스트에 Car 객체 자체 생성
       }
       return cars;
   }

    public void race(){
       this.tryNo--;
       moveCars();
    }

    private void moveCars() {
       for (Car car : cars) {
           car.move(getRandomNo()); //car.move() 였다가 car.move(getRandomNo());
       }
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    /**
     * Random, 시스템변수를상위 class node에 위임
     * Car 객체의 getRandomNo()->int + import public static으로 MAX_BOUND 변환 >
     * => RacingGame 객체의 getRandomNo()->int + car.move(getRandomNo())
     * => Car 객체에서는 Random 객체 아예 의존성 사라짐
     */

    public boolean racing() { return this.tryNo > 0;}

    public List<Car> getCars() { return Collections.unmodifiableList(cars);}

    public Object getWinners() { return null;
    }
}
