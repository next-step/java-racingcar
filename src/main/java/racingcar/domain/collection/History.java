package racingcar.domain.collection;

import racingcar.domain.model.Memento;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * NOTE: Memento 의 일급 컬렉션
 * FIXME: racingcar.domain.collection 가 적절한지 확인 필요.
 * 자바의 Collection 데이터 타입에 종속되는 패키지명이므로 혼동을 줄 수 있음.
 * Memento 클래스 한개만 의존하고 있으므로,
 * composition 이나, aggregation 이라는 표현은 부적절해보임.
 * FIXME: collection 보다 적절한 패키지명을 추천받을 필요 있음.
 */
public class History {
    private List<Memento> mementoList;

    public History() {
        mementoList = new LinkedList<>();
    }

    private History(List<Memento> mementoList) {
        this.mementoList = mementoList;
    }

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    private List<Memento> cloneMementoList() {
        List<Memento> mementoList = new LinkedList<>();
        for (Memento memento : mementoList) {
            mementoList.add(
                    memento.clone()
            );
        }
        return mementoList;
    }

    public List<Memento> getMementoList() {
        List<Memento> mementoList = cloneMementoList();
        return Collections.unmodifiableList(
                new LinkedList(mementoList)
        );
    }

    @Override
    public History clone() {
        List<Memento> mementoList = cloneMementoList();
        return new History(mementoList);
    }
}
