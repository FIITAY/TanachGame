package itay.finci.org.biblegame;


public class Periodic {
    private String name;
    private  String option1,option2,option3,option4;

    public Periodic(String name1, String op1, String op2,String op3,String op4){
        name = name1;
        option1 = op1;
        option2 = op2;
        option3 = op3;
        option4 = op4;
    }

    public Periodic(Periodic p) {
        name = p.name;
        option1 = p.option1;
        option2 = p.option2;
        option3 = p.option3;
        option4 = p.option4;
    }

    public String getName() {
        return name;
    }

    public void setName(String body) {
        this.name = body;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
