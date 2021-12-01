DROP TABLE SOLVED_QUIZLIST;
DROP TABLE RANDOM_QUIZLIST;
DROP TABLE QUIZ;
DROP TABLE MEMBER;


CREATE TABLE QUIZ(
    QUIZNO INT PRIMARY KEY,
    QUESTION VARCHAR(1000),
    ANSWER INT,
    EXONE VARCHAR(100),
    EXTWO VARCHAR(100),
    EXTHREE VARCHAR(100),
    EXFOUR VARCHAR(100)
    );

CREATE TABLE MEMBER(
    MEMID VARCHAR(20) PRIMARY KEY,
    MEMPW VARCHAR(20), 
    NICKNAME VARCHAR(20)
    );
ALTER TABLE MEMBER
    ADD SCORE INT;
    
CREATE TABLE RANDOM_QUIZLIST(
    R_QUIZNO INT PRIMARY KEY,
    QUIZ_ONE INT REFERENCES QUIZ(QUIZNO),
    QUIZ_TWO INT REFERENCES QUIZ(QUIZNO),
    QUIZ_THREE INT REFERENCES QUIZ(QUIZNO),
    QUIZ_FOUR INT REFERENCES QUIZ(QUIZNO),
    QUIZ_FIVE INT REFERENCES QUIZ(QUIZNO),
    QUIZ_SIX INT REFERENCES QUIZ(QUIZNO),
    QUIZ_SEVEN INT REFERENCES QUIZ(QUIZNO),
    QUIZ_EIGHT INT REFERENCES QUIZ(QUIZNO),
    QUIZ_NINE INT REFERENCES QUIZ(QUIZNO),
    QUIZ_TEN INT REFERENCES QUIZ(QUIZNO)
    );
CREATE TABLE SOLVED_QUIZLIST(
    TRYCOUNT INT,
    MEMID VARCHAR(20) REFERENCES MEMBER(MEMID),
    QUIZNO VARCHAR(20) REFERENCES RANDOM_QUIZLIST(R_QUIZNO),
    CONSTRAINT PK_SOLVEQUIZ_CNT_ID PRIMARY KEY (TRYCOUNT, MEMID)
    );
ALTER TABLE SOLVED_QUIZLIST
    ADD SCORE INT;

insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (1,'프로그램에 필요한 자바 가상 기계(JVM) 라이브러리 API 컴파일러 등의 개발 도 구가 포함된 소프트웨어 패키지',1,'JDK','JVM','IDE','JRE');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (2,'자바 프로그램 실행에 필요한 자바 가상 기계(JVM) 라이브러리 API가 포함된 소 프트웨어 패키지',4,'JDK','JVM','IDE','JRE');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (3,'객체를 생성하기 위한 필드와 메소드가 정의된 것. 객체의 설계도에 해당한다.',1,'클래스','변수','메소드','상수');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (4,'프로젝트 생성 자동 코드 완성 디버깅 기능을 제공하는 환경 ex) Eclipse(자바) Visual Studio(C/C++)',3,'JDK','JVM','IDE','JRE');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (5,'모의실행을 해서 코드의 오류를 찾는 행위',2,'컴파일','디버깅','리팩터링','클린코드');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (6,'다음 중 참조 타입(reference type)이 아닌것은?',3,'클래스 타입','열거 타입','문자 타입','인터페이스 타입');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (7,'다음 중 원시 타입(primitive type)이 아닌것은?',2,'정수','문자열','논리 리터럴을 저장하는 자료형','실수');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (8,'클래스로 부터 만들어진 객체를 무엇이라고 하는가?',1,'instance','constructor','Singleton','Prototype');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (9,'다음 설명에 알맞은 답을 고르시오. 부모에게서 상속받은 메소드의 내용이 자식 클래스에 맞지 않을 경우 ß자식 클래스에서 동일한 메소드를 재정의하는 것을 말한다. ',1,'overriding','overloading','inheritance','interface');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (10,'매개 변수를 달리하는 같은 이름의 메소드를 여러개 선언하는 기술을 무엇이라 하는가?',2,'overriding','overloading','inheritance','interface');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (11,'다음은 무엇에 대한 설명인가? 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음으로 라이브러리(Library)라고도 부른다.',1,'API','multi process','framework','system call');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (12,'다음은 무엇에 대한 설명인가? 후입선출LIFO: Last In First Out 자료구조로 나중에 넣은 객체가 먼저 빠져나간다.',2,'Queue','Stack','Heap','LinkedList');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (13,'다음은 무엇에 대한 설명인가? 프로그램이 외부 파일 외부 네트워크 등과 통신할 때 데이터가 흐르는 길. 이 때 외부란 같은 컴퓨터 내부라도 프로그램의 바깥에 별도로 존재하는 것을 말한다. ',1,'stream','buffer','cache','session');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (14,'데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역은 무엇인가?',2,'stream','buffer','cache','session');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (15,'인스턴스가 생성될 때 만들어지는 변수가 아닌 처음 프로그램이 메모리에 로딩될 때 할당하는 메모리 영역은?',1,'static','final','stack','heap');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (16,'접근 제한자의 종류 중  자신의 클래스를 제외한 외부 클래스에서 접근할 수 없도록 하는 접근 제한자는? ',4,'public','default ','protected','private');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (17,'클라이언트의 연결을 수락하고 연결된 클라이언트와 통신하는 역할을 하는 연결 지향적 통신 프로토콜은 무엇인가?',3,'HTTP','UDP','TCP','SMTP');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (18,'바이트 기반 입력 스트림의 최상위 클래스인 추상클래스는?',1,'InputStream','OutputStream','Reader','Writer');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (19,'인스턴스가 생성되어 힙영역에 저장하는 JAVA 예약어 ( )은 무엇인가?',3,'void','int','new','final');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (20,'객체를 생성할 때 호출하는 것으로 객체의 초기화 작업을 주로 담당하며 인스턴스 생성 시에 실행되어야 할 작업을 위해서도 사용되며 이것의 이름은 클래스의 이름과 같아야하며 리턴 값이 없다. 이 때 이것은 무엇인가?',2,'instance','constructor','Singleton','Prototype');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (21,'자바에서 GUI(Graphic User Interface)를 구현하기 위해 JDK에서 기본적으로 제공하는 라이브러리는 무엇인가?',1,'swing','jdbc','SLF4J','Log4j 2');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (22,' 풍부한 무료 라이브러리가 많아 개발 기간 단축에 도움을 주며 설계적인 측면이 강조된 객체 지향 언어로 유지보수에 용이하고 안정성과 확장성이 높고 운영체제에 독립적인 프로그래밍 언어는 무엇인가?',2,'C','java','javascript','알골');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (23,'자바 클래스명을 정의할 때 권장하는 표기법으로 첫 글자를 대문자로 구성하며 단어가 합성될 때 마다 각 단어의 첫 글자를 대문자로 표기하는 방식의 표기법은 무엇인가?',1,'파스칼 표기법','스네이크 표기법','캐멀 표기법','헝가리안 표기법');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (24,'자바 변수명과 매소드명을 정의할 때 권장하는 표기법으로 첫 글자는 소문자로 시작하며 단어가 합성될 때마다 각 단어의 첫 글자는 대문자로 표기하는 방식은 무엇인가?',3,'파스칼 표기법','스네이크 표기법','캐멀 표기법','헝가리안 표기법');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (25,'실제로 구현되는 부분을 외부에 드러나지 않도록 캡슐로 감싸 이용방법만을 알려주는것의 자바 객체지향 언어의 특징은 무엇인가?',1,'캡슐화','다형성','추상화','은닉화');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (26,' 내부 연산을 외부에서 접근하지 못하도록 변수에 접근지정자를 private 로 지정하고 setter, getter를 사용에 접근 제어하는 객체지향 언어의 특징은 무엇인가?',4,'캡슐화','다형성','추상화','은닉화');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (27,'상위 개념의 특징을 하위 개념이 물려 받는 객체 지향 언어의 개념은 무엇인가?',1,'상속','형변환','객체생성','프로토콜');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (28,'공통의 속성이나 기능을 묶어 이름을 붙이는 객체 지향 언어의 특징은 무엇인가?',3,'캡슐화','다형성','추상화','은닉화');
insert into QUIZ(QUIZNO, QUESTION, ANSWER, EXONE, EXTWO, EXTHREE, EXFOUR) values (29,'TCP/IP 기반 네트워크 통신으로 자바가 Oracle, MySQL과 같은 Database에 접근할 수 있도록 해주는 라이브러리(프로그래밍 API) 는 무엇인가?',2,'swing','jdbc','SLF4J','Log4j 2');
SELECT * FROM QUIZ;

insert into MEMBER(MEMID, MEMPW, NICKNAME, SCORE) values ('Yeonha','1234','YH',2);
insert into MEMBER(MEMID, MEMPW, NICKNAME, SCORE) values ('HyeonWoo','1234','HW',4);
insert into MEMBER(MEMID, MEMPW, NICKNAME, SCORE) values ('DongJin','1234','DJ',6);
insert into MEMBER(MEMID, MEMPW, NICKNAME, SCORE) values ('m1','m1','m1',7);
insert into MEMBER(MEMID, MEMPW, NICKNAME, SCORE) values ('yh','yh','yh',8);

SELECT * FROM MEMBER;

COMMIT;