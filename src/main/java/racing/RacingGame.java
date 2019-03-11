package racing;

import java.util.ArrayList;

/*
    ########################################################
    말씀하신대로 GameRule 클래스를 별도로 생성해두긴 했는데
    테스트코드 작성하는게 쉽지가 않내요..

    보통 각 클래스의 기능별로 테스트코드를 따로 작성해서
    결과 값을 확인하나요?

    현재는 기능을 전체 구현하고 테스트코드를 작성하고있내요...ㅜ.ㅜ
    습관이 아직 잡히지 않은것 같습니다.

    ########################################################
 */

public class RacingGame {
    // 운행횟수
    private int time;
    // Car 컬렉션
    private ArrayList<Car> list;

    public int getTime() {
        return this.time;
    }

    public ArrayList<Car> getList() {
        return this.list;
    }

    public void initRacingGame(final int time, final int carCount) {
        this.time = time;

        list = new ArrayList<Car>();
        for (int i = 0; i < carCount; i++) {
            list.add(new Car());
        }
    }

    public void runRacingGame(GameRule gameRule) {
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < list.size(); j++) {
                list.get(j).move(gameRule.randomNumberRule());
            }
        }
    }
}