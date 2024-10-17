package step4;

import java.util.Arrays;
import java.util.List;

public class RacingCarFactory {

    static RacingCar createRacingCarWithInputView() {

        String carInfo = RacingCarInputView.scanCarInfo();
        int numberOfRace = RacingCarInputView.scanNumberOfRace();

        return createRacingCar(splitCarInfo(carInfo), numberOfRace);
    }

    static List<String> splitCarInfo(String carInfo){
        if(carInfo == null || carInfo.length() == 0)
            throw new RuntimeException();

        List<String> carNameList = Arrays.asList(carInfo.split(","));

       if(carNameList.stream().anyMatch(info->info.length()>5))
           throw new IndexOutOfBoundsException();

       return carNameList;
    }

    static RacingCar createRacingCar(List<String> carInfoList, int numberOfRace) {
        return new RacingCar(carInfoList, numberOfRace);
    }
}
