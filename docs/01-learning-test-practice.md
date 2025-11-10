# 1단계 - 학습 테스트 실습
***
## 코드 리뷰
> PR 링크:
> [https://github.com/next-step/java-racingcar/pull/6170](https://github.com/next-step/java-racingcar/pull/6170)
## 나의 학습 목표
- 익숙한 Java API로 단위테스트를 작성하여 향후 좋은 습관을 위해 학습테스트를 실습해본다.
## String 클래스에 대한 학습 테스트
### 요구사항
- [x] `"1,2"`을 `,`로 `split` 했을 때 1과 2로 잘 분리되는지 확인하 테스트를 구현한다.
- [x] `"1"`을 `,`로 `split` 했을 때 1만을 포함하는 배열 반환되는지 대한 학습 테스트를 구현한다.
- [x] `"(1,2)"`값이 주어졌을 때 String의 `substring()` 메서드를 활용해 `()`을 제거하고 `"1,2"`를 반환하도록 구현한다.
- [x] `"abc"`값이 주어졌을 때 String의 `charAt()` 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 `charAt()` 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 `StringIndexOutOfBoundsException` 발생하는 부분에 대 학습 테스트를 구현한다.
- [x] JUnit의 `@DisplayName`을 활용해 테스트 메소드의 의도를 드러낸다.
## Set Collection에 대한 학습 테스트
### 요구사항
- [x] Set의 `size()` 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
- [x] Set의 `contains()` 메소드를 활용해 `1, 2, 3`의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    - JUnit의 `ParameterizedTest`를 활용해 중복 코드를 제거해 본다.
- [x] 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도 구현한다.
    - ex) `1, 2, 3`값은 `contains` 메소드 실행결과 `true`, `4,5` 값을 넣으면 `false`가 반환되는 테스트를 하나의 Test Case로 구현한다.