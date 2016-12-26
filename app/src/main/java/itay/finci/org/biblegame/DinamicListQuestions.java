package itay.finci.org.biblegame;

/**
 * Created by itay on 26/12/16.
 */
public class DinamicListQuestions {
    private  String first,second,third,forth, fith;

    public DinamicListQuestions(String first, String second, String third, String forth, String fith) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.forth = forth;
        this.fith = fith;
    }

    public DinamicListQuestions(DinamicListQuestions dlq){
        first = dlq.first;
        second = dlq.second;
        third = dlq.third;
        forth = dlq.forth;
        fith = dlq.fith;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getForth() {
        return forth;
    }

    public void setForth(String forth) {
        this.forth = forth;
    }

    public String getFith() {
        return fith;
    }

    public void setFith(String fith) {
        this.fith = fith;
    }
}
