package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamMinMaxTest {
    @Test
    void whenListIsOfIntegerThenMaxCanBeDoneUsingIntegerComparator() {
        //given
        List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,56,7,89,10);
        Integer expectedResult = 89;
        //then
        Integer max = listOfIntegers
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);

        assertThat(max).isEqualTo(expectedResult);
    }

    @Test
    void whenListIsOfMemberObjectThenMinCanBeDoneUsingCustomComparatorLambda() {
        //given
        Member alex = new Member("Alex", 24);
        Member ben = new Member("ben", 50);
        Member peter = new Member("peter", 35);
        List<Member> members = Arrays.asList(ben, alex, peter);
        //then
        Member minByAge = members
                .stream()
                .min(Comparator.comparing(Member::getAge)) //passing a labmda func as a coparator
                .orElseThrow(NoSuchElementException::new);

        assertThat(alex).isEqualTo(minByAge);
    }


    @Test
    void whenThenComparingThenSortedByAgeName() {
        //given
        Member alex = new Member("Alex", 24);
        Member simon = new Member("simon", 35);
        Member ben = new Member("ben", 50);
        Member peter = new Member("peter", 35);
        List<Member> members2 = Arrays.asList(ben, simon, alex, peter);

        Comparator<Member> member_Age_Name_Comparator
                = Comparator.comparing(Member::getAge)
                    .thenComparing(Member::getName);

        List<Member> expected = Arrays.asList(alex, peter, simon, ben);

        assertThat(members2).isEqualTo(expected);

    }

}
