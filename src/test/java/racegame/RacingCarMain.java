package racegame;


import java.util.*;

public class RacingCarMain {


    public static void main(String[] args) {
        String[] carNameList={"car1","car2","car3"};
            //= new RacingName().nameInput();

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
        for (Map<String, Object> cmap : carNameListInfo) {
            if (Integer.parseInt(cmap.get("goStep").toString()) == score) {
                success += cmap.get("carName") + ".....";
            }
        }
        System.out.println(success);

    }
}
