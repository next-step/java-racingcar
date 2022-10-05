# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 기능 목록
- 자동차 정보를 담당하는 Car 객체 생성
  - 객체 생성 시, 이름 5자 초과 여부 판단
  - 스스로 판단하여 전진
  - 자동차 현재 위치 정보
  - 자동차 이름 정보
- 자동차 객체들을 관리하는 Cars 객체 생성
  - 게임 우승자 판정
  - 자동차 객체들에게 랜덤 숫자를 던져 움직이도록 한다.
- 게임의 사용자 유저 메시지 입출력을 담당하는 클라이언트 기능 추가 (UI)
  - inputView
     - 클라이언트에게서 자동차 이름들을 입력 받는다. 
     - 클라이언트에게서 게임 횟수를 입력 받는다.
  - resultView
     - 게임 우승자를 클라이언트에게 보여준다.
     - 각 라운드 결과를 클라이언트에게 보여준다.
- 게임 메인 RacingGame 클래스 생성
  - 게임 READY : 사용자의 정보 입력을 기반으로 자동차 모델 초기화
  - 게임 진행

- 자동차 이동 시 값 증가 검증 테스트 코드 추가 CarTest
- 게임 우승자 판정 검증 RacingGameTest