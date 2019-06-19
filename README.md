# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현할 기능 목록

### step2 
- [x] 사용자가 몇 대의 자동차로 몇 번의 이동을 할 것인지 입력하는 기능
- [x] (추가) 자동차의 속성 정의
- [x] 입력받은 자동차 수에 따라 자동차를 생성하는 기능
- [x] 생성된 자동차를 화면에 출력하는 기능
- [x] 자동차의 전진 여부를 무작위으로 결정하는 기능
- [x] 자동차가 전진 할 경우 화면에 출력될 변화를 설정하는 기능
- [x] 입력받은 실행 횟수에 따라 경주를 실행하는 기능
- [x] 실행 결과를 화면에 출력하는 기능
- [x] (추가) 구조 리팩토링

### step3
- [ ] 자동차 이름들을 입력하여 자동차 대수를 결정
    - [x] 자동차 객체에 carName 필드 추가
    - [x] 자동 이름 입력하는 UI 추가
    - [ ] 입력받은 자동차 이름들을 ','로 구분해서 배열/리스트로 저장
    - [ ] 자동차 이름들(CarNames) 일급콜렉션 추가
    - [ ] 입력된 자동차 이름들(또는 배열/리스트의 길이) 만큼 자동차 대수 생성하도록 수정
        - [ ] 테스트 코드
    - [ ] 자동차 이름 입력 유효성 체크
        - [ ] 테스트 코드
- [ ] 경주완료 후 우승자 선정 및 출력
    - [ ] 우승자 객체 추가
    - [ ] 우승자 선정 로직 추가
        - [ ] 테스트 코드