package jung;


import java.util.*;

public class RacingGame {
    int random = 0;
    int count = 0;
    HashMap<String, String> hash = new HashMap<String, String>();
    ArrayList<String> winner = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    RacingGame() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = scan.nextInt();
    }

    /**
     * 움직이는 메서드
     */
    void isMove(int random, String carName) {
        if ((random >= 4) && hash.get(carName) == null) {
            hash.put(carName, "-");
            return;
        }
        if (random >= 4) {
            hash.put(carName, hash.get(carName) + "-");
            return;
        }
        hash.put(carName, "");
    }

    /**
     * 화면에 현황 표시 메서
     */
    void display(String[] cars) {
        for (String carName : cars) {
            System.out.println(carName + ":" + hash.get(carName));
        }
    }

    /**
     * 승자 정하는 메서
     */
    void win(String[] cars) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String carName : cars) {
            result.put(carName, hash.get(carName).length());
        }
        int maxValueInMap = Collections.max(result.values());
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                winner.add(entry.getKey());
            }
        }
    }

    /**
     * 레이싱 시작메서
     */
        void racingStart (String[]cars){
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < cars.length; j++) {
                    random = (int) (Math.random() * 10);
                    isMove(random, cars[j]);
                }
                display(cars);
            }
            win(cars);
            System.out.print("최종 우승자 : ");
            for(String winner : winner){
                System.out.println(winner);
            }
        }
    }
