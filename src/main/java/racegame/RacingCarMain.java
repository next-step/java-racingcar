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
        List<RacingCar> carList = new ArrayList();
        List<Integer> scoreList = new ArrayList<>();
        int max=0;
        String result = "승자는";

        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for (String carname : carNameList) {
            RacingCar car = new RacingCar(carname, 0);
            carList.add(car);
        }

        for (int i = 0; i < count; i++) {
            for(RacingCar car : carList){
                RacingGameRenewal gameOne = new RacingGameRenewal();
                scoreList.add(gameOne.RacingGame(car));
            }
            System.out.println("");
        }
        max= Collections.max(scoreList);

        for(RacingCar car : carList){
            if(car.getGoStep() == max){
                result += car.getCarName() +",";
            }
        }
        result = result.substring(0, result.lastIndexOf(","));
        System.out.println(result);
    }
}
