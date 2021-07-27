package racing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Racing {

    static Boolean isShow = false;

    public static void main(String args[]) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer carNum = setNumber();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer tryNum = setNumber();
        playGame(carNum, tryNum);

    }

    public static Integer setNumber() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void playGame(Integer carNum, Integer tryNum) {

        Integer[] carList = gameInitiate(carNum);

        while(isGameOver(carList, tryNum)) {
            carList = setCarMove(carList);
            showGame(carList);
        }
    }

    public static Boolean isGameOver(Integer[] carList, Integer tryNum) {
        for(int idx = 0; idx < carList.length ; idx++) {
            if (tryNum.equals(carList[idx])) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] gameInitiate(int carNum) {
        Integer[] carList = new Integer[carNum];
        for(int idx = 0; idx < carNum; idx++) {
            carList[idx] = 0;
        }
        return carList;
    }

    public static void showGame(Integer[] carList) {
        if(!isShow) {
            return;
        }

        System.out.println("");

        for(int idx = 0; idx < carList.length; idx++) {
            String movement = "";
            for(int cnt = 0; cnt < carList[idx]; cnt++) {
                movement = movement + "-";
            }
            System.out.println(movement);
        }
    }

    public static Integer[] setCarMove(Integer[] carList) {
        isShow = false;
        for(int idx = 0; idx < carList.length; idx++) {

            if(isMove(makeRanNum())) {
                carList[idx] = carList[idx] + 1;
            }
        }
        return carList;
    }

    public static Integer makeRanNum() {
        Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
        random.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음
        return random.nextInt(10);
    }

    public static Boolean isMove(Integer number) {


        if(number >= 4) {
            isShow =  true;
            return true;
        }
        return false;
    }


}
