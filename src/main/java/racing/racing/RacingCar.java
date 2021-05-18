package racing.racing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RacingCar {
    //쪼개는 함수
    public String[] splitName(String allName) {
        String[] array = allName.split(",");
        for (int i = 0; i < array.length; i++) {
            excess(array, i);
        }

        return array;
    }

    //5글자인지 판단하는 함수 (5글자 초과면 4글자로 자르기)
    private String excess(String[] array, int i) {
//        System.out.println("이봐" + array[i].length());
        if (array[i].length() > 4) {
            array[i] = array[i].substring(array[i].length() - 4);
            System.out.println(array[i]);
            return array[i];
        } else {
            return array[i];
        }
    }

    //무작위 값 구하기(조건 0에서 9)
    public String randomNumber() {
        Random random = new Random();
        String str = "";
        int number = random.nextInt(10);
//        System.out.println("number : " + number);
        if (number >= 4) {
            str = "-";
        } else {
            str = "";
        }

        return str;
    }


    //실행 횟수에 따라
    public String[] raceStart(String name, int count) {
        String spName[] = splitName(name);
        for (int j = 0; j < count; j++) {
            doRace(spName,j);
        }
        return spName;
    }

    private String[] doRace(String[] spName,int count) {
        for (int i = 0; i < spName.length; i++) {
            String hyphen = randomNumber();
            if(count == 0){
                spName[i] = spName[i]+" : " + hyphen;
            }
            else{
                spName[i] = spName[i]+ hyphen;
            }
        }

        for (int i = 0; i < spName.length ; i++) {
            System.out.println(spName[i]);
        }
        System.out.println("=============================");
        return spName;
    }


    public void winner(String[] result) {
        String[] findWinner = new String[result.length];
        String[] findWinnerIndex = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            findWinner[i] = result[i].substring(result[i].lastIndexOf(":")+2);
            findWinnerIndex[i] = String.valueOf(findWinner[i].length());
            //            System.out.println("findwinner[i] : " + findwinner[i]);
        }
        Arrays.sort(findWinnerIndex, Collections.reverseOrder());

        String winner = "";
        for (int i = 0; i <findWinnerIndex.length ; i++) {
//            System.out.println("비교");
//            System.out.println(findWinnerIndex[0]);
//            System.out.println(findWinner[i].length());
//            System.out.println("========");
            if(findWinnerIndex[0].equals(String.valueOf(findWinner[i].length()))){
                winner = winner + result[i].split(" ")[0]+" ";
            }
        }
        System.out.println("winner : "+winner);
    }
}
