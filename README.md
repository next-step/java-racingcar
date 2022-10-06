# 자동차 경주 게임

## 5단계 - 자동차 경주(리팩토링)

### 리팩토링 요구사항

* MVC 패턴 기반으로 리팩토링한다.
* 패키지
  * domain  : 핵심 비즈니스 로직을 가지는 객체
  * view : UI 관련 객체
* view 패키지의 객체가 domain 패키지의 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않아야 한다.

## 4단계 - 자동차 경주(우승자)

### 기능 목록

* `자동차 이름`과 `시도할 횟수`를 입력받아야 한다.
  * `자동차 이름`은 `,`를 기준으로 구분한다.
  * `자동차 이름`은 5자를 초과할 수 없다.
  * `시도할 횟수` 값으로 음수를 전달할 경우 예외가 발생해야 한다.
* 전진하는 조건을 만족하면 자동차는 1칸 전진한다.
* 0 ~ 9 사이의 랜덤 값을 생성하여 값이 4 이상일 경우 자동차는 전진한다.
* 자동차 경주 결과는 아래의 정보를 가지고 있어야 한다.
  * 각 시도(라운드)별 `자동차 이름`과 해당 자동차가 `움직인 거리`
  * `자동차 경주 우승자`
    * `자동차 경주의 우승자`는 여러 명일 수 있다.
* 자동차 경주 결과를 출력한다.

## 3단계 - 자동차 경주

### 기능 목록

* `자동차 대수`와 `시도할 횟수`를 입력받아야 한다. 
  * `자동차 대수` 값으로 음수를 전달할 경우 예외가 발생해야 한다.
  * `시도할 횟수` 값으로 음수를 전달할 경우 예외가 발생해야 한다.
* 전진하는 조건을 만족하면 자동차는 1칸 전진한다.
* 0 ~ 9 사이의 랜덤 값을 생성하여 값이 4 이상일 경우 자동차는 전진한다.
* 자동차 경주 결과는 아래의 정보를 가지고 있어야 한다.
  * 각 시도(라운드)별 `자동차가 움직인 거리`
* 자동차 경주 결과를 출력한다.
