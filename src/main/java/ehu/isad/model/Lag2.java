package ehu.isad.model;

public class Lag2 {

    private String target;
    private String server;
    private String se;


    public String getTarget() {
        return target;
    }
    public String getServer(){ return  server;}
    public String getSe(){ return  se;}


    public void setTarget(String target) {
        this.target = target;
    }
    public void setServer(String server) { this.server = server; }
    public void setSe(String se) { this.se = se; }
    public Lag2(String target, String server, String se) {
        this.target = target;
        this.server = server;
        this.se = se;
    }
}