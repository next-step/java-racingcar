# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 스텝 3

* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
*  전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
*  자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 스텝 3
1> 
1-1. 각 자동차에 이름을 부여할 수 있다. 
1-2. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
2> 자동차 이름은 쉼표(,)를 기준으로 구분한다.
3> 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

---
정리
---


## [step 2](https://github.com/next-step/java-racingcar/pull/722) 

- Class 에 직접 psvm 을 만들어서 실행시키기 보다는 필요한 경우는 별도 ***Application > main() 형태로 실행

- 연산에 대항 항의 갯수가 같고 연산자만 다르거나 연산항의 타입이 다른 경우 추상화를 시도해본다.

-  반복된 코드가 발견 되면 , 코드가 클래스의 성격에 따라 적절한 위치가 어디인지 파악하고 중복을 최소화.

- 정규화 패턴을 사용시, Pattern.matches 는 내부적으로 Pattern.compile 을 호출하여 Pattern 인스턴스가
매번 만들어지기 때문에 상수화 시켜서 사용.

    - https://velog.io/@edwin/JAVA-%EC%A0%95%EA%B7%9C%EC%8B%9D-%EC%84%B1%EB%8A%A5%EC%97%90-%EB%8C%80%ED%95%B4-Pattern.matcher-VS-String.matches
      https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
      
- input/output 에 대한 클래스를 별도로 분리/유틸리티화 시키고, 주 클래스의 생성자에서 받아서 쓰는 방식

- Test case 작성시, 테스트 입력값에 null 을 넣고 싶은 경우 @NullSource 를 활용 @ NullSource or NullAndEmptySource
    - @ParameterizedTest 를 사용해야 함. @Test 대신.. 
    -  https://gmlwjd9405.github.io/2019/11/27/junit5-guide-parameterized-test.html
    
- Test 시, @CsvSource 에서 "1:2" ->  문자열로 인식하지 않고 int 로 바로 사용가능.


    





[step 3](https://github.com/next-step/java-racingcar/pull/856)




[step 4](https://github.com/next-step/java-racingcar/pull/935)


