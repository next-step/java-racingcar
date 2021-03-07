# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


##기능 요구사항
- 사용자가 문자열을 입력 가능하도록 한다
- 문자 입력 시 사칙 연산 사이에는 빈칸이 존재하도록 한다
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다
- 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 사칙 연산을 모두 포함하는 기능 구현


#String 클래스 테스트

## 요구사항 1
- 문자를 컴마로 split 했을 때 분리가 되는지 테스트 코드 구현
- 반환 되는 값이 맞는지 contains , containsExactly 메소드로 확인한다

## 요구사항 2
- substring() 메소드를 활용한 후 ()제거하고 1,2 반환 되는 값을 확인하는 테스트 코드 구현

## 요구사항 3 
- DisplayName 메소드 의도 표현
- charAt 메소드를 활용해 특정 위치 문자 비교하는 메소드 구현
- charAt 메소드 활용 시 인덱스가 인데스 넘어가면  StringIndexOutOfBoundsException 발생하는 메소드 구현
 

#Set Collection에 대한 학습 테스트

## 요구사항 1
- size 메소드를 활용해 Set의 크기를 확인하는 메소드 구현

## 요구사항 2
- contains 을 활용해 Set 안에 1,2,3 값이 존재하는 메소드 구현
- ParameterizedTest 메소드로 중복 코드 제거

## 요구사항 3
-  contains 1,2,3 값을 확인 후 ture 결과가 나오면 Set에 4,5 을 넣고 false 나오도록 메소드 구
