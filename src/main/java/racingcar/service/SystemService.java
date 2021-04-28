package racingcar.service;

import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SystemService {
    MoveService moveService = new MoveService();

    public List<Car> carInfo = new ArrayList<Car>();

    public void splitString(String input){
        String[] result = input.split(",");
        for (int i=0;i<result.length;i++){
           Car carVO = new Car();

           carVO.setName(result[i]);
           carVO.setLocationInfo(" ");

           carInfo.add(carVO);
        }
    }
    public String MoveCar(String locationInfo){
        String check = moveService.isMove();
        String movedLocation = Operation.result(check,locationInfo);
        return movedLocation;
    }
}
