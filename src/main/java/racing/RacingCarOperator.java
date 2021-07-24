package racing;

import java.util.Random;

public class RacingCarOperator {
    int numOfCar;
    int numOfCycle;
    int[] carLocation;

    public RacingCarOperator(int[] racingInputInfo) {
        this.numOfCar = racingInputInfo[0];
        this.numOfCycle = racingInputInfo[1];
        carLocation = new int[this.numOfCar];
    }

    public void Run() {
        // 초기 위치 설정 (1)
        Random rd = new Random();
        for (int i = 0; i < numOfCar; i++) {
            carLocation[i] = 1;
        }

        // 4-1) 시도 회수가 0일 경우 다음 단계로 이동.
        // 4-2) 시도 회수가 1이상 일 경우 로직 1단계로 이동.
        while (numOfCycle != 0) {
            for (int i = 0; i < numOfCar; i++) {
                // 1) 주어진 자동차의 수 만큼 랜덤값을 뽑음. (랜덤 값의 범위는 0~9)
                int randNum = rd.nextInt(10);
                // 2) 랜덤 값의 따라 1칸 전진 혹은 멈춤.
                // 2-2) 랜덤 값이 4~9 사이인 경우 1칸 전진.
                // 2-1) 랜덤 값이 0~3 사이인 경우는 현상유지.
                if (randNum >= 4) {
                    carLocation[i] = carLocation[i] + 1;
                }
            }

            for (int i = 0; i < numOfCar; i++) {
                // 3) 현재 자동차의 위치 상태를 표시
                for (int j = 0; j < carLocation[i]; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
            // 4) 시도 회수 -= 1
            numOfCycle--;
        }
    }
}
