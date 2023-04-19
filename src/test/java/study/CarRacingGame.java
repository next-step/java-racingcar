package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class CarRacingGame {

    public void doCarRacingGame(){
        BufferedReader br = null;
        StringBuffer sb = null;

        // try/catch문은 한단계 들어가기에 포함되지 않겠지?
        try{
            br = new BufferedReader(new InputStreamReader((System.in)));
            sb = new StringBuffer();

            System.out.println("자동차 대수는 몇 대 인가요?");
            int carCnt = Integer.parseInt(br.readLine());
            if(!confirmCarCnt(carCnt)) {
                System.out.println("종료");
            }

            System.out.println("시도할 회수는 몇 회 인가요?");
            int racingCnt = Integer.parseInt(br.readLine());
            if(!confirmMoveCnt(racingCnt)) {
                System.out.println("종료");
            }

            String[] carRoads = initializeCar(carCnt);
            for(int i=0;i<racingCnt;i++){
                carRoads = doCarRacing(carRoads);
                sb = recordRacingResult(sb, carRoads);
            }

            System.out.println();
            System.out.println("실행 결과");
            System.out.println(sb.toString());

            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean confirmCarCnt(int data) {
        if(data == 0) {
            return false;
        }

        return true;
    }

    /* confirmCarCnt와 실제로는 같은 로직이기는 하지만, 향후 자동자 대수와 이동횟수가 달라질 수 있다는 가능성이 보여서 일단 분리를 해두었다. */
    public boolean confirmMoveCnt(int data) {
        if(data == 0) {
            return false;
        }

        return true;
    }

    public String[] initializeCar(int data){
        String[] arr = new String[data];
        for(int i=0;i<arr.length;i++){
            arr[i] = "-";
        }

        return arr;
    }

    public String[] doCarRacing(String[] carArr){
        for(int i=0;i<carArr.length;i++){
            boolean isUp = determineMove();
            carArr = addDistance(carArr, i, isUp);
        }

        return carArr;
    }

    private boolean determineMove() {
        Random rd = new Random();
        int randomCnt = rd.nextInt(10);

        return determineMoveByCnt(randomCnt);
    }

    private boolean determineMoveByCnt(int data){
        if(data < 4) {
            return false;
        }

        return true;
    }

    private String[] addDistance(String[] carArr, int index, boolean isUp){
        if(isUp) {
            carArr[index] += "-";
        }

        return carArr;
    }

    public StringBuffer recordRacingResult(StringBuffer racingResult, String[] carArr){
        StringBuffer sb = racingResult;

        for(int i=0;i<carArr.length;i++) {
            sb.append(carArr[i]).append("\n");
        }

        sb.append("\n");
        return sb;
    }

    public static void main(String[] args){
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.doCarRacingGame();
    }
}
