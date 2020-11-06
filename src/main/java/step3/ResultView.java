package step3;

import java.util.List;

public class ResultView {

    /**
     * Car 의 이동거리 List 를 화면에 그려줍니다.
     *
     * @param movingDistances Car 의 이동거리 List
     */
    public void draw(List<Integer> movingDistances) {
        movingDistances.stream().forEach(this::displayMovingDistance);
        System.out.println("");
    }

    /**
     * 출발선은 | 로 표시
     * 이동한거리만큼 - 로 표시
     *
     * @param distance
     */
    private void displayMovingDistance(Integer distance) {
        System.out.print("|");
        while (distance-- > 0) {
            System.out.print('-');
        }
        System.out.println("");
    }
}
