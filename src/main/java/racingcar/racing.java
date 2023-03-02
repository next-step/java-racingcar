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

        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scan.nextLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int    drivingDistance = scan.nextInt();
        scan.close();

        String carNameList[] = carNames.split(",");
        List<racingCar> carList = new ArrayList<racingCar>();
        for (int ii = 0; ii < carNameList.length; ii++) {
            carList.add(new racingCar(carNameList[ii].trim()));
        }

        boolean racingEnd = false;
        for (int ii = 0; racingEnd == false ; ii++) {
            drivingCar(carList);
            racingEnd = racingStatus(carList, drivingDistance);
            System.out.println("\n");
        }
        StringBuilder resultBuffer = new StringBuilder("최종 우승자 : ");
        for (int ii = 0; ii < carList.size(); ii++) {
            racingCar valCar = carList.get(ii);
            if (valCar.getDistance().equals(drivingDistance) == false)
                continue;
            resultBuffer.append(valCar.getName());
            resultBuffer.append(",");
        }
        resultBuffer.delete(resultBuffer.length()-1, resultBuffer.length());
        System.out.println(resultBuffer.toString());
    }
}
