/*
* 클래스 이름  : Racing
* 버전 정보 : 0.0v
* 날짜 2021.07.27
* 저작권 주의 : 본 과제는 next-step 자료입니다.
* */

package racing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Racing {

    private static ShowRacing showRacing = new ShowRacing();

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

        ArrayList<Integer> carList = gameInitiate(carNum);

        while(isGameOver(carList, tryNum)) {
            carList = setCarMove(carList);
            //showGame(carList);
        }
    }

    public static Boolean isGameOver(ArrayList<Integer> carList, Integer tryNum) {

        for(int idx = 0; idx < carList.size(); idx++) {
            if (tryNum.equals(carList.get(idx))) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> gameInitiate(int carNum) {

        ArrayList<Integer> carList = new ArrayList<>();
        for(int idx = 0; idx < carNum; idx++) {
            carList.add(0);
        }

        return carList;
    }

    public static ArrayList<Integer> setCarMove(ArrayList<Integer> carList) {

        for(int idx = 0; idx < carList.size(); idx++) {
            String movement = "";

            if(isMove(makeRanNum())) {
                int cntSize = carList.get(idx) + 1;
                carList.set(idx, cntSize);

                showRacing.showGame(cntSize, carList.size(), idx);
            }
        }

        return carList;
    }

    public static Integer makeRanNum() {

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(10);

    }

    public static Boolean isMove(Integer number) {

        if(number >= 4) {
            return true;
        }

        return false;
    }


}
