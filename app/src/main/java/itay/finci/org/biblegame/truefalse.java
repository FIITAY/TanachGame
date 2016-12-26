package itay.finci.org.biblegame;

/**
 * Created by itay on 26/12/16.
 */
public class truefalse {
    private String name;
    private boolean tf;

    public truefalse(truefalse t) {
        name = t.name;
        tf = t.tf;
    }

    public truefalse(String name, boolean tf) {
        this.name = name;
        this.tf = tf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTf() {
        return tf;
    }

    public void setTf(boolean tf) {
        this.tf = tf;
    }
}
