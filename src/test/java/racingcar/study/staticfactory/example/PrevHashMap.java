package racingcar.study.staticfactory.example;

import java.util.HashMap;

public class PrevHashMap {
    // 정적 팩토리 메서드: type inference를 이용한다
    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();
    }

}
