package step3.study.view;

import step3.study.domain.Car;
import step3.study.domain.Recodes;
import step3.study.domain.ResponseRacingDTO;

import java.util.List;

public class ResultView {
    public void showResultView(ResponseRacingDTO responseRacingDTO) {
        List<Recodes> recodesList = responseRacingDTO.getRecodesList();
        System.out.println("실행결과");
        for(Recodes recodes : recodesList){
            printRecodeDistance(recodes);
            System.out.println();
        }
    }

    private void printRecodeDistance(Recodes recodes) {
        List<String> recode = recodes.getRecodes();
        for(String distance : recode){
            System.out.println(distance);
        }
    }

}
