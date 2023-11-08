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

        ArrayList<RacingCar> carList = RacingCarGame.creatCar("4","car1,car2,car3,car4","3");
        assertThat(carList.size()).isEqualTo(4);
        assertThat(carList.get(0).getLoopCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("반복 횟수 만큰 생성한 Random 숫자 중 4보다 큰 값 Count")
    void count_4보다큰값() {

        ArrayList<Double> randomList = new ArrayList<Double>();

        randomList.add(0, 3.2);
        randomList.add(1, 5.1);
        randomList.add(2, 8.4);

        int result = countDrive(randomList);
        assertThat(result).isEqualTo(2);

    }

    @Test
    @DisplayName("최고 전진 횟수")
    void maxCount_최고수() {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();
        String[] carNameList = {"car1","car2","car3"};
        int stepNum = 4;
        ArrayList<Double> randomList0 = new ArrayList<>(List.of(1.2, 2.3, 5.1, 6.8)); //전진 2
        ArrayList<Double> randomList1 = new ArrayList<>(List.of(4.2, 5.3, 5.1, 6.8)); //전진 4
        ArrayList<Double> randomList2 = new ArrayList<>(List.of(7.2, 5.3, 5.1, 6.8)); //전진 4

        carList.add(new RacingCar(carNameList[0],countDrive(randomList0),stepNum,randomList0));
        carList.add(new RacingCar(carNameList[1],countDrive(randomList1),stepNum,randomList1));
        carList.add(new RacingCar(carNameList[2],countDrive(randomList2),stepNum,randomList2));

        assertThat(maxStep(carList)).isEqualTo(4);

    }
    @Test
    @DisplayName("우승 차량 확인")
    void champion() {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();
        String[] carNameList = {"car1","car2","car3"};
        int stepNum = 4;
        ArrayList<Double> randomList0 = new ArrayList<>(List.of(1.2, 2.3, 5.1, 6.8)); //전진 2
        ArrayList<Double> randomList1 = new ArrayList<>(List.of(4.2, 5.3, 5.1, 6.8)); //전진 4
        ArrayList<Double> randomList2 = new ArrayList<>(List.of(7.2, 5.3, 5.1, 6.8)); //전진 4

        carList.add(new RacingCar(carNameList[0],countDrive(randomList0),stepNum,randomList0));
        carList.add(new RacingCar(carNameList[1],countDrive(randomList1),stepNum,randomList1));
        carList.add(new RacingCar(carNameList[2],countDrive(randomList2),stepNum,randomList2));

        ArrayList<RacingCar> nameList = championList(carList,4);

        String namestr = nameList.get(0).getCarName()+","+ nameList.get(1).getCarName();

        assertThat(namestr).contains("car2");
        assertThat(namestr).contains("car3");

    }

    @Test
    @DisplayName("우승 차량명 합치기")
    void combineName_이름합치기() {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();
        String[] carNameList = {"car1","car2","car3"};
        int stepNum = 4;
        ArrayList<Double> randomList0 = new ArrayList<>(List.of(1.2, 2.3, 5.1, 6.8)); //전진 2
        ArrayList<Double> randomList1 = new ArrayList<>(List.of(4.2, 5.3, 5.1, 6.8)); //전진 4
        ArrayList<Double> randomList2 = new ArrayList<>(List.of(7.2, 5.3, 5.1, 6.8)); //전진 4

        carList.add(new RacingCar(carNameList[0],countDrive(randomList0),stepNum,randomList0));
        carList.add(new RacingCar(carNameList[1],countDrive(randomList1),stepNum,randomList1));
        carList.add(new RacingCar(carNameList[2],countDrive(randomList2),stepNum,randomList2));

        String namestr = combineName(carList);;

        assertThat(namestr).contains("car1, car2, car3");

    }


}
