package study;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;


public class AssertJTest {

//AssertJConditionUnit
    private Condition<Member> senior = new Condition<>(m-> m.getAge() >= 60, "senior");
    private Condition<Member> nameJohn = new Condition<>(m-> m.getName().equalsIgnoreCase("John"), "name John");

    @Test
    public void whenUsingMemberAgeCondition_thenCorrect(){
        Member member = new Member("John", 65);
        assertThat(member).is(senior);

        try {
            assertThat(member).isNot(senior);
            fail();
        } catch (AssertionError e) {
            assertThat(e).hasMessageContaining("not to be <senior>");
        }
    }

    @Test
    public void whenUsingMemberNameCondition_thenCorrect(){
        Member member = new Member("Jane", 60);
        assertThat(member).doesNotHave(nameJohn);

        try {
            assertThat(member).has(nameJohn);
            fail();
        } catch (AssertionError e) {
            assertThat(e).hasMessageContaining("<name John>");
        }
    }

    @Test
    public void whenCollectionConditionsAreSatisfied_thenCorrect(){
        List<Member> members = new ArrayList<>();
        members.add(new Member("Alice", 50));
        members.add(new Member("Bob", 60));

        assertThat(members).haveExactly(1, senior);
        assertThat(members).doNotHave(nameJohn);
    }

    @Test
    public void whenCombiningAllOfConditions_thenCorrect(){
        Member john = new Member("John", 60);
        Member jane = new Member("Jane", 50);

        assertThat(john).is(allOf(senior, nameJohn));
        assertThat(jane).is(allOf(not(nameJohn), not(senior)));
    }

    @Test
    public void whenCombiningAnyOfConditions_thenCorrect(){
        Member john = new Member("John", 50);
        Member jane = new Member("Jane", 60);

        assertThat(john).is(anyOf(senior, nameJohn));
        assertThat(jane).is(anyOf(nameJohn, senior));
    }
    //AssertJCoreUnit (asList ERROR : intelliJ 's List func)

    //AssertJJAVA8Unit
    @Test
    public void giveOptional_shouldAssert() throws Exception{
        final Optional<String> giveOptional = Optional.of("something");

        assertThat(giveOptional).isPresent().hasValue("something");
    }

    @Test
    public void givenLocalDate_shouldAssert() throws Exception{
        final LocalDate givenLocalDate = LocalDate.of(2012,7,24);
        final LocalDate todayDate = LocalDate.now();

        assertThat(givenLocalDate).isBefore(LocalDate.of(2022,7,24))
                .isAfterOrEqualTo(LocalDate.of(1993,7,24));
        assertThat(todayDate).isAfter(LocalDate.of(2020,7,24)).isToday();
    }

    @Test
    public void givenLocalTime_shouldAssert() throws Exception{
        final LocalTime givenLocalTime = LocalTime.of(12,15);

        assertThat(givenLocalTime).isAfter(LocalTime.of(11,0)).hasSameHourAs(LocalTime.of(12,0));
    }

    //satisfies helper method, all provided assertions as a LAMBDA body
    @Test
    public void givenString_shouldSatisfy() throws Exception{
        final String givenString = "someString";

        assertThat(givenString).satisfies(s -> {
            assertThat(s).isNotEmpty();
            assertThat(s).hasSize(10);
        });
    }

    //matches helper method matches predicate LAMBDA function
    @Test
    public void givenString_shouldMatch() throws Exception{
        final String emptyString = "";
    //메서드 레퍼런스 타입 & 함수 타입 합동 ::
        assertThat(emptyString).matches(String::isEmpty);
    }
}
