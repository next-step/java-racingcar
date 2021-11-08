package step3.view;

import step3.service.MakeRandomList;
import step3.service.MoveOrStop;

import java.util.ArrayList;

public class Output {
    private ArrayList<String> inputCarList;
    private Integer countOfTry;

    public Output(ArrayList<String> inputCarList, Integer countOfTry) {
        this.inputCarList = inputCarList;
        this.countOfTry = countOfTry;
    }

    public void outputView() {
        System.out.println("실행 결과");
        for (int i = 0; i < countOfTry; i++) {
            MoveOrStop moveOrStop = new MoveOrStop();
            MakeRandomList makeRandomList = new MakeRandomList();

            ArrayList<Integer> randomList = makeRandomList.makeRandomList(inputCarList.size());
            ArrayList<String> movedCarList = moveOrStop.moveOrStop(inputCarList, randomList);

            movedCarList.stream().forEach(System.out::println);
            System.out.println("");
            this.inputCarList = movedCarList;
        }
    }
}
