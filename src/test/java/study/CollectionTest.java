package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionTest {
    @DisplayName("[study]ArrayList와 LinkedHashMap은 순서를 보장한다.")
    @Test
    void ArrayList_and_LinkedHashMap_guarantee_order() {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        List<Map<Object, Integer>> given = new ArrayList<>();
        Map<Object, Integer> map1 = new LinkedHashMap<>();
        map1.put(object1, 0);
        map1.put(object2, 0);
        map1.put(object3, 1);
        given.add(map1);

        Map<Object, Integer> map2 = new LinkedHashMap<>();
        map2.put(object1, 0);
        map2.put(object2, 1);
        map2.put(object3, 2);
        given.add(map2);

        Map<Object, Integer> map3 = new LinkedHashMap<>();
        map3.put(object1, 1);
        map3.put(object2, 1);
        map3.put(object3, 3);
        given.add(map3);

        assertThat(given).hasSize(3);
        assertThat(given.get(0)).hasSize(3);
        assertThat(given.get(0).values()).containsExactly(0, 0, 1);
        assertThat(given.get(1).values()).containsExactly(0, 1, 2);
        assertThat(given.get(2).values()).containsExactly(1, 1, 3);
    }

    @DisplayName("[study]key가 객체인 Map에서 객체로 value를 조회할 수 있다.")
    @Test
    void search_value_using_key_Object() {
        Object object1 = new Object();
        Object object2 = new Object();

        Map<Object, Integer> map = new LinkedHashMap<>();
        map.put(object1, 1);
        map.put(object2, 0);

        assertThat(map.get(object1)).isEqualTo(1);
        assertThat(map.get(object2)).isZero();
    }
}
