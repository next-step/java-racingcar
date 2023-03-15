package CarRacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    static int[] totalCount = new int[10000];

    static int tryCount = 0;
    static int check = 0;

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scan = new Scanner(System.in);

        return getCarObjects(scan.nextLine());
    }

    public static List<String> getCarObjects(String input) {
        return Arrays.asList(input.split(",")).stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
    public static boolean checkCarName(List<String> CarName){
        if (CarName.stream().anyMatch(name->name.length()>5) ){
            //throw new IllegalArgumentException("이름이 5글자를 초과했습니다.");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

        List<String> carNames = getCarNames();
        if( !checkCarName(carNames) ){
            throw new IllegalArgumentException("이름이 5글자를 초과했습니다.");
        }
        Scanner in = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
        tryCount = in.nextInt();
        initTotalCount(carNames);
        for (int i = 0; i < tryCount; i++) {
            tryGo(carNames);
        }
        String winNames = lastWinName(carNames);
        System.out.println("최종우승자 : " + winNames);
    }

    public static void initTotalCount(List<String> Name) {

        for (int i = 0; i < Name.size(); i++) {
            totalCount[i] = 0;
        }
    }

    public static String lastWinName(List<String> Name) {
        String winNames = "";
        for (int i = 0; i < Name.size(); i++) {
            winNames = winNames + winner(i, Name);
        }
        return winNames;
    }

    public static void tryGo(List<String> car) {
        int j = 0;
        String strHyphen = "";
        for (int i = 0; i < car.size(); i++) {
            strHyphen = "";
            j = (int) (Math.random() * 10);
            strHyphen = hyphen(i, j);
            System.out.println(car.get(i) + " : " + strHyphen);
        }
        System.out.println(" ");
    }

    public static String hyphen(int carnum, int randomcnt) {
        String hyphen = "";
        if (randomcnt >= 4) {
            totalCount[carnum] = totalCount[carnum] + 1;
        }
        for (int i = 0; i < totalCount[carnum]; i++) {
            hyphen = hyphen + "-";
        }
        return hyphen;
    }

    public static String winner(int carnum, List<String> car) {
        String carName = "";
        if (totalCount[carnum] == tryCount && check == 0) {
            check++;
            return car.get(carnum);
        }
        if (totalCount[carnum] == tryCount && check > 0) {
            return "," + car.get(carnum);
        }
        return "";
    }
}
