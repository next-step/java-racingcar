package step5.controller;

import step5.domain.Racing;
import step5.domain.Referee;
import step5.domain.car.Cars;
import step5.view.InPutView;

public class Core {
    public static void main(String[] args) {
        // inputview
        String names =  InPutView.name();
        int howManyTry = InPutView.howManyTimesToTrye();

        // 요구사항에 따라 판정 기준이 달라질 수 있어 전략패턴을 사용할 수 있습니다.
        // 다만 현재의 요구사항으로는 추상화에 대한 필요성이 없습니다. 자동차 전진 판정 방식 추가되는 시기에 추상화하는 것이 바람직하다고 생각합니다.

        Referee referee = new Referee();
        Racing racing = Racing.defaultOf(names,referee,howManyTry);

        Racing racingResult = racing.start();
        Cars winners = racingResult.winnerIs();

        // 최대한 View객체가 도메인으로 침투하지 않는 방식을 생각해봤습니다.
        // 상태에 대한 값이 아니라 String을 반환받아 출력하는 형식으로 도전해봤습니다.
        // 진행 상태에 대한 출력은 경기 진행 중 기록으로 남겨 마지막에 출력하는 방식으로 했습니다.
        OutPutView outPutView = new OutPutView();
        outPutView.printHistory(racing);
        outPutView.winnerIs(winners);

    }
}
