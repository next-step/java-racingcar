package racingcar;

import java.util.*;

public class racing {
    static void drivingCar (List<racingCar> _carList) {
        for (int ii = 0; ii < _carList.size(); ii++) {
            _carList.get(ii).drive();
        }
    }

    static boolean racingStatus (List<racingCar> _carList, int _drivingDistance) {
        boolean endRacing = false;

        for (int ii = 0; ii < _carList.size(); ii++) {
            racingCar valCar = _carList.get(ii);
            System.out.println(valCar.getStatus());
            if (valCar.getDistance().equals(_drivingDistance))
                endRacing = true;
        }
        return endRacing;
    }

    public static  void main(String[] args) {
        String carNameList[] = "abc, def, hji".split(",");
        int    drivingDistance = 5;
        int    ii;
        boolean racingEnd = false;
        List<racingCar> carList = new ArrayList<racingCar>();

        for (ii = 0; ii < carNameList.length; ii++) {
            carList.add(new racingCar(carNameList[ii].trim(), (ii + 1) * 2));
        }

        for (ii = 0; racingEnd == false ; ii++) {
            drivingCar(carList);
            racingEnd = racingStatus(carList, drivingDistance);
            System.out.println("\n");
        }
        System.out.println("\nchampion");
        for (ii = 0; ii < carList.size(); ii++) {
            racingCar valCar = carList.get(ii);
            if (valCar.getDistance().equals(drivingDistance))
                System.out.println(valCar.getStatus());
        }
    }
}
