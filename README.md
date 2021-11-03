# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## STEP2 피드백 반영여부
 - Calculator.class calculate 메소드 책임 분리
```
여러 책임을 가지고 있는 calcuate의 책임들을 어떻게 구분해서 나누고 어떻게 분리를 시킬까?
```
 - Calculator.class 매직넘버 상수로 치환
```
매직 넘버 : 상수(static final)로 선언되지 않은 숫자
매직 리터럴 : 상수(static final)로 선언되지 않은 문자
String[] result = input.split(" "); 에서 " "는 매직 리터럴이다.
사용해선 안되는 이유
1. 무엇을 의미하는지 확신할 수 없다.
2. 의미를 파악하기 위해 클래스를 이해하고, 코드의 흐름을 이해하기 위한 시간과 노력이 소요된다.

사용해서 얻을 수 있는 효과
1. 상수로 선언하게 되면 값의 이름이 생기기 때문에 어떤 역할인지 바로 파악이 가능하다.
```
 - CalculatorMain.class main 메소드 수식을 Calculator.class 생성자로 처리
```
수식을 Calculator.class의 맴버변수로 선언
생성자를 통해 수식을 넣어주게 되면 즉시 초기화가 가능하다.
이렇게 초기 값을 설정하게 되면 생성되는 객체들 모두 같은 데이터를 갖을 수 있다.
```
 - Enum Class 명 변경 (EOperation.class)
```
Operator.class 로 변경
```
 - 사용하지 않는 import 정리
 - CalculatorTest.class dataFormatException 메소드 throws 제거
```
assertThatExceptionOfType 를 통해 예외를 잡기 때문에 throws 는 불필요!
```