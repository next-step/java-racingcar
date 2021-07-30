package step3;

import java.util.Scanner;

public class CarGame {
    private Car[] cars;

    public CarGame(int carCnt, int tryCnt) {
        cars = new Car[carCnt];
        for (int i=0; i<carCnt; i++) {
            cars[i] = new Car(tryCnt);
        }
        this.cars = cars;
    }

    public int getAllCar() {
        return cars.length;
    }

    public Car getCar(int i) {
        return cars[i];
    }

    public void canMove(int carIdx, int randomNum) {
        int curMove = cars[carIdx].getMove();
        int curPlay = cars[carIdx].getPlay();

        //4미만일때는 시도횟수만줄임
        if (randomNum < 4) {
            cars[carIdx].setPlay(curPlay - 1);
            return;
        }

        //4이상일때는 전진하고 시도횟수 줄임
        cars[carIdx].setMove(curMove + 1);
        cars[carIdx].setPlay(curPlay - 1);
    }

    public String printDistance(int carIdx) {
        int curMove = cars[carIdx].getMove();

        StringBuilder sb = new StringBuilder();
        while (curMove-- > 0){
            sb.append("-");
        }

        return sb.toString();
    }


    public static boolean isDigit(String input){
        if(input == null || input.trim().length() > 0){
            return input.matches("[0-9]*");
        }

        return false;
    }

    public static int ask(Message category) {
        int cnt = 0;
        while (cnt <= 0){
            //시도횟수 입출력
            Scanner sc = new Scanner(System.in);
            System.out.println(category.getInputMessage());
            String userInput = sc.nextLine();

            //숫자가 아닐경우 예외처리
            if(!isDigit(userInput)){
                System.out.println("숫자로 입력해주세요.");
                continue;
            }

            cnt = Integer.parseInt(userInput);
            if(cnt > 0){
                return cnt;
            }
            //0개 이하 예외처리
            System.out.println(category.getErrorMessage());
        }

        return cnt;
    }

    public static void main(String[] args) {
        int carCnt = ask(Message.ASK_CAR_CNT);
        System.out.println("자동차 대수 :" + carCnt);

        int playCnt = ask(Message.ASK_TRY_CNT);
        System.out.println("시도 횟수 :" + playCnt);
    }


}
