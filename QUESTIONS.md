# 앞서

앞으로 다음과 같이 표기하고자 합니다.

> - [ ] 아직 답을 받지 못한 질문
> - [x] ~~답을 받은 질문~~

# QUESTIONS

- [ ] [~~조건을 달아서 하나의 테스트 코드로 만드는 것이 가능할까요? 가능하다면 그게 적절한 방안인가요?~~](https://github.com/next-step/java-racingcar/pull/950#discussion_r435045177)
  - 예를 들어, `RandomRacingRule`의 경우 `bound`가 0 이하일 경우 `IllegalArgumentException`을 던지고, 아닐 경우 잘 생성된다. 라는 걸 표현하고 싶어요.
  - [ ] [이 리뷰](https://github.com/next-step/java-racingcar/pull/950#discussion_r435045177)에서 말씀하신 정상일 때의 테스트 코드라는 것이 감이 잡히지 않아서. ~~고민하다가 이것이 NotNull이다~~ AssertJ 문서를 보다가 doesNotThrowAnyException으로 테스트 코드를 작성하게 되었는데, 더 나은 방법이 있을까요?
- [x] [~~private method는 어떻게 테스트하는 것이 좋을까요?~~](https://github.com/next-step/java-racingcar/pull/950#discussion_r433089075)
- [x] [~~test code에서 반복되는 코드를 묶어서 메소드로 만드는 게 적절한 걸까요?~~](https://github.com/next-step/java-racingcar/pull/950#discussion_r433089085)
- [x] [~~조언에 따라서 RacingRule이란 것을 분리하여 만들었는데, 하다보니 오직 테스트만을 위한 객체를 만들까라는 생각이 들어 만들게 되었니다. 적절한 선택일까요?~~](https://github.com/next-step/java-racingcar/pull/950#discussion_r435044446)
- [x] [~~`RandomRacingRule`로 떼어 냈더니 `canGoForward()`를 어떻게 테스트해야 할 지 전혀 감이 잡히지 않습니다...~~](https://github.com/next-step/java-racingcar/pull/950#discussion_r435044457)
- [x] [~~[이 리뷰](https://github.com/next-step/java-racingcar/pull/950#discussion_r433089480)에서 말씀하시는 것이, RacingRule이라는 녀석을 넣음으로, 객체 비교가 애매해진 것 같아요... 이러한 경우에도 expectCar 객체를 만드는 게 좋은 선택인가요?~~](https://github.com/next-step/java-racingcar/pull/950#discussion_r435045222)
