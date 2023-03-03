package CarRacing;

import java.util.Scanner;

public class CarRace {

    static int[] totCnt = new int[10000];
    static int cnt = 0;
    static int check = 0;

    public static void main(String[] args){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner in = new Scanner(System.in);

        String carName = in.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        cnt = in.nextInt();

        String[] Name = carName.split(",");

        for(int i=0; i< Name.length; i++) {
            totCnt[i] = 0;
        }

        for(int i=0; i < cnt; i++)
        {
            System.out.println(" ");
            tryGo(Name);
        }

        String winNames = "";

        for(int i=0; i< Name.length; i++)  {
            winNames = winNames + winner(i, Name);
        }
        System.out.println("\n최종우승자 : " + winNames);
    }
    public static void tryGo(String[] car){

        int j=0;
        String strHyphen = "";

        for(int i=0; i< car.length; i++)
        {
            strHyphen = "";
            j = (int)(Math.random() * 10);
            strHyphen = hyphen(i, j);
            System.out.println(car[i] + " : " + strHyphen);
        }
    }
    public static String hyphen(int carnum, int randomcnt){

        String hyphen = "";

        if(randomcnt >= 4) {
            totCnt[carnum] = totCnt[carnum] + 1;
        }

        for(int i=0; i<totCnt[carnum]; i++){
            hyphen = hyphen + "-";
        }
        return hyphen;
    }
    public static String winner(int carnum, String[] car){
        String carName = "";
        if(totCnt[carnum] == cnt && check == 0){
            check ++;
            return car[carnum];
        }else if(totCnt[carnum] == cnt && check > 0)
        {
            return "," + car[carnum];
        }
        return  "";
    }
}
