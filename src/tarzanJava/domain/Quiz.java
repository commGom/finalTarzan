package tarzanJava.domain;

public class Quiz {
    private int quizNo;
    private String question;
    private int answer;
    private String ex01;
    private String ex02;
    private String ex03;
    private String ex04;

    public Quiz(int quizNo, String question, int answer, String ex01,String ex02,String ex03,String ex04) {
        this.quizNo = quizNo;
        this.question = question;
        this.answer = answer;
        this.ex01=ex01;
        this.ex02=ex02;
        this.ex03=ex03;
        this.ex04=ex04;
    }

    public Quiz() {
    }

    public int getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(int quizNo) {
        this.quizNo = quizNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getEx01() {
        return ex01;
    }

    public void setEx01(String ex01) {
        this.ex01 = ex01;
    }

    public String getEx02() {
        return ex02;
    }

    public void setEx02(String ex02) {
        this.ex02 = ex02;
    }

    public String getEx03() {
        return ex03;
    }

    public void setEx03(String ex03) {
        this.ex03 = ex03;
    }

    public String getEx04() {
        return ex04;
    }

    public void setEx04(String ex04) {
        this.ex04 = ex04;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizNo=" + quizNo +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
