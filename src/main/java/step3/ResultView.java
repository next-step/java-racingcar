package step3;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> racingCarList, int repeatCnt) {
        for(int repeat=0; repeat<repeatCnt; repeat++){
            for(int carNum=0; carNum<racingCarList.size(); carNum++){
                System.out.println(racingStatus(racingCarList.get(carNum), repeat));
            }
            System.out.println();
        }
    }

    public static String racingStatus(Car car, int repeat) {
        String carStatus = "";
        for(int progress = 0; progress<=repeat; progress++) {
            if (car.carSpeed[progress] >= 4) {
                carStatus += "-";
            }
        }
        return carStatus;
    }
}
