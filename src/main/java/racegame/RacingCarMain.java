package racegame;

import java.util.*;

public class RacingCarMain {


    public void racemain() {
        String[] carNameList = new RacingName().nameInput();

        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scan.nextInt();
        ArrayList<Map<String, Object>> carNameListInfo = new RacingGame().racingSetting(carNameList);
        System.out.println("실험 결과");
        for (int i = 0; i < count; i++) {
            carNameListInfo = new RacingGame().racingGoing(carNameListInfo);
            System.out.println("");
        }

        List list = new ArrayList();
        for (Map<String, Object> cmap : carNameListInfo) {
            list.add(cmap.get("goStep"));
        }

        String success = "승자는 :";

        int score = (int) Collections.max(list);
        for (int i = 0; i < carNameListInfo.size(); i++) {
            Map oneMap = carNameListInfo.get(i);
            if (Integer.parseInt(oneMap.get("goStep").toString()) == score) {
                success += oneMap.get("carName") + ",";
            }
        }
        success = success.substring(0, success.lastIndexOf(","));
        System.out.println(success);

    }

    public void reviewReflectMain() {
        String[] carNameList = new RacingName().nameInput();
        ArrayList carList = new ArrayList();

        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

//        for (int i = 0; i < carNameList.length; i++) {
        for (String carname : carNameList) {
            RacingCar car = new RacingCar(carname, 0);
            carList.add(car);
        }
        for (int i = 0; i < count; i++) {
            for(Object car : carList){
                new RacingGameRenewal(car);
            }
        }
    }
}
