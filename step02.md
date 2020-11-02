- 타입없는 자바 스크립트만 하다가 자바를 보니 깜짝 놀랬다
- 어떻게 해야 될지 막막해서 다른사람의 코드를 보고 더 깜짝놀랬다
- 자바 고수들이 다모였군!! 
- 자바에 익숙해 질 때까지 고수들이 작성한 코드와 글들을 카피해서 배워야 겠다!

- @DongHwani 님
    - 코드 베이스 
    - interface, enum
    
- @junilHwang 님
    - 상수 사용
    - 생성자 실행방지
    - 인터페이스 -> 람다 
        - 람다표현식과 BiFunction apply Interface Override
    - Math::addExact
        - :: 은 함수의 등록과 같은것  값으로 함수를 다룰 수 있는 것
    - `BiFunction<Integer, Integer, Integer> race`
        - 열거형 `PLUS("+", Math::addExact)` 의 두번째 인자인 람다함수 `Math::addExact` 의 
        - 첫번째 인자의타입, 두번째 인자의 타입, 마지막은 반환 타입을 나타낸다. 
        - Operator.Class 의 calculate 메서드란 
            ```java
            public int calculate(int x, int y) {
                return race.apply(x, y);
            }
            ```
        - race 란 Math::addExact 를 의미하는데 인자 x, y 를 넣어 함수를 실행시킨다.
        - apply 를 하는 이유는 BiFunction 의 인터페이스의 apply 를 통해 함수를 실행시킬 수 있기 때문이다.
        - java 는 오지게 추상화가 되어있구나
        - Operator 의 마지막 클래스 메서드는 executeOf 이다.
            - type 에는 '+', '-', '*', '/' 이 올 것이고,
            - x 와 y 는 연산할 숫자이다.
            - stream 에 대해서는 잘 모르는데 순회할 수 있는 용도로 보인다.
            - values() 는, 사실상 this.values() 인데, 자바 클래스에서는 this 를 생략할 수 있다고 한다. 
            - 여기서 가리키는 this 는 열거형의 요소들이다.
            - 따라서 다음 filter 에 들어가는 람다인자 race 는 각각의 열거형 요소이다. 
            - findFirst 는 앞 stream 에서 가장 첫 요소를 가져오는 것 같다.
            - orElseThrow: 연산을 끝난 앞선 객체가 비어있다면 throw 를 한다. type 과 일치하는 race 가 없는 경우
            ```java
                public static int executeOf(String type, int x, int y) {
                    return Arrays.stream(values())
                                 .filter(race -> race.operatorType.equals(type))
                                 .findFirst()
                                 .orElseThrow(InValidOperatorException::new)
                                 .calculate(x, y);
                }
            ```
          - `@MethodSource` 의 인자는 Stream
          ```java
            private static Stream<Arguments> provideOperatorAndOperandsAndResult () {
                return Stream.of(
                    Arguments.of(Operator.PLUS, 1, 2, 3),
                    Arguments.of(Operator.MINUS, 1, 2, -1),
                    Arguments.of(Operator.MULTIPLE, 1, 2, 2),
                    Arguments.of(Operator.DIVIDE, 4, 2, 2)
                );
            }
        ```
    
- @oen142 님
    - 에러 커스텀

@neojjc2 -> @ghojeong 
```text
Mock 테스트를 하신 이유를 여쭤봐도 될까요??  😄 
저는 보통 행위검증을 할 때 Mocking 테스트를 사용하지만, 기존에 작성되어있는 수많은 의존적인 부분들 때문에 제가 테스트하고자 하는 부분을 테스트 할 수 없어서 의존적인 부분을 제거하기 위해 Mocking 처리를 합니다
이번 미션은 정완님이 다 설계하고 구현하셨기 때문에 수정이 불가능한 의존적인 부분은 없습니다
작성한 method가 정상적으로 호출이 되었는지 로직적인 부분을 검증하기 보다는 실제 예측한 값이 나오는지에 좀 더 집중해서 테스트 작성을 고민해주시면 class 설계나 test코드 작성에 좀 더 도움이 되실거라 생각합니다 (Mockito를 사용 안하실 수 있습니다)
후반 미션으로 가실 수록 유닛테스트 코드 작성을 위해 계속 method와 class를 쪼개는 연습을 하실 텐데요  😄  미리부터 연습하신다는 마음으로 임해주셨으면 좋겠습니다
응원하겠습니다  🔥 
```

- 0 으로 나눌 경우 에러처리
- 멤버 변수가 필요 없다면, 유틸 클래스 형태로 만들어보면 어떨까요?

- @oen142 님의 error 커스텀


