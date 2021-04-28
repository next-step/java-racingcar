package racingcar.service;

import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;

public class SystemService {
    public List<Car> carInfo = new ArrayList<Car>();

    public void splitString(String input){
        String[] result = input.split(",");
        for (int i=0;i<result.length;i++){
           Car carVO = new Car();

           carVO.setName(result[i]);
           carVO.setLocationInfo(null);

           carInfo.add(carVO);
        }
    }

}
