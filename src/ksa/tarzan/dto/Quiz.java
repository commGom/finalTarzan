package ksa.tarzan.dto;

public class Quiz {
    private int quizNo;
    private String question;
    private int answer;
    private String exOne;
    private String exTwo;
    private String exThree;
    private String exFour;
    public Quiz() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Quiz(int quizNo, String question, int answer, String exOne, String exTwo, String exThree, String exFour) {
        super();
        this.quizNo = quizNo;
        this.question = question;
        this.answer = answer;
        this.exOne = exOne;
        this.exTwo = exTwo;
        this.exThree = exThree;
        this.exFour = exFour;
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
    public String getExOne() {
        return exOne;
    }
    public void setExOne(String exOne) {
        this.exOne = exOne;
    }
    public String getExTwo() {
        return exTwo;
    }
    public void setExTwo(String exTwo) {
        this.exTwo = exTwo;
    }
    public String getExThree() {
        return exThree;
    }
    public void setExThree(String exThree) {
        this.exThree = exThree;
    }
    public String getExFour() {
        return exFour;
    }
    public void setExFour(String exFour) {
        this.exFour = exFour;
    }
    @Override
    public String toString() {
        return "Quiz [quizNo=" + quizNo + ", question=" + question + ", answer=" + answer + ", exOne=" + exOne
                + ", exTwo=" + exTwo + ", exThree=" + exThree + ", exFour=" + exFour + "]";
    }



}
