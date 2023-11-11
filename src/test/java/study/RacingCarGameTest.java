package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static study.RacingCarGame.*;
import static study.RacingCarGame.combineName;

public class RacingCarGameTest {


    @Test
    @DisplayName("4대의 차량이 3번 래이싱 테스트")
    void creatCar_차량생성() {

        String[] names = {"car1","car2","car3","car4"};
        ArrayList<RacingCar> carList = RacingCarGame.creatCar(4,names,3);
        assertThat(carList.size()).isEqualTo(4);
    }


    @Test
    @DisplayName("최고 전진 횟수")
    void maxCount_최고수() {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();
        String[] carNameList = {"car1","car2","car3"};
        int stepNum = 4;
        ArrayList<Integer> randomList0 = new ArrayList<>(List.of(1, 2, 5, 6)); //전진 2
        ArrayList<Integer> randomList1 = new ArrayList<>(List.of(4, 5, 5, 6)); //전진 4
        ArrayList<Integer> randomList2 = new ArrayList<>(List.of(7, 5, 5, 6)); //전진 4

        carList.add(new RacingCar(carNameList[0],2,randomList0));
        carList.add(new RacingCar(carNameList[1],4,randomList1));
        carList.add(new RacingCar(carNameList[2],4,randomList2));

        assertThat(maxStep(carList)).isEqualTo(4);

    }
    @Test
    @DisplayName("우승 차량 확인")
    void champion() {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();
        String[] carNameList = {"car1","car2","car3"};
        int stepNum = 4;
        ArrayList<Integer> randomList0 = new ArrayList<>(List.of(1, 2, 5, 6)); //전진 2
        ArrayList<Integer> randomList1 = new ArrayList<>(List.of(4, 5, 5, 6)); //전진 4
        ArrayList<Integer> randomList2 = new ArrayList<>(List.of(7, 5, 5, 6)); //전진 4

        carList.add(new RacingCar(carNameList[0],2,randomList0));
        carList.add(new RacingCar(carNameList[1],4,randomList1));
        carList.add(new RacingCar(carNameList[2],4,randomList2));

        ArrayList<RacingCar> nameList = championList(carList,4);

        String namestr = nameList.get(0).carName()+","+ nameList.get(1).carName();

        assertThat(namestr).contains("car2");
        assertThat(namestr).contains("car3");

    }

    @Test
    @DisplayName("우승 차량명 합치기")
    void combineName_이름합치기() {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();
        String[] carNameList = {"car1","car2","car3"};
        int stepNum = 4;
        ArrayList<Integer> randomList0 = new ArrayList<>(List.of(1, 2, 5, 6)); //전진 2
        ArrayList<Integer> randomList1 = new ArrayList<>(List.of(4, 5, 5, 6)); //전진 4
        ArrayList<Integer> randomList2 = new ArrayList<>(List.of(7, 5, 5, 6)); //전진 4

        carList.add(new RacingCar(carNameList[0],2,randomList0));
        carList.add(new RacingCar(carNameList[1],4,randomList1));
        carList.add(new RacingCar(carNameList[2],4,randomList2));

        String namestr = combineName(carList);;

        assertThat(namestr).contains("car1, car2, car3");

    }


}
