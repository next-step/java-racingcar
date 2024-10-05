package racingcar.study.staticfactory.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.study.staticfactory.example.PrevHashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4.형인자 자료형 객체를 만들때 편리하다
 *
 * Java 1.7 이전에는 다음과 같이 형인자 자료형 객체를 만들어야 했다.
 * Map<String, List<String>> list = new HashMap<String, List<String>>();
 *
 * 그러나 이 장점은 Java 1.7 이후로는 의미를 거의 잃었다.
 * Map<String, List<String>> list = new HashMap<>();
 */
public class HashMapTest {
    @Test
    void newInstance() {
        Map<String, List<String>> constructorHashMap = new HashMap<>();
        HashMap<String, List<String>> constructorPrevHashMap = new HashMap<String, List<String>>();
        HashMap<String, List<String>> staticFactoryPrevHashMap = PrevHashMap.newInstance();

        Assertions.assertThat(constructorHashMap).isEqualTo(staticFactoryPrevHashMap);
        Assertions.assertThat(constructorPrevHashMap).isEqualTo(staticFactoryPrevHashMap);
    }
}
