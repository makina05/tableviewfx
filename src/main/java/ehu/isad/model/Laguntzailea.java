package ehu.isad.model;


//CMS erlaitzeko taul abetetzeko erabiliko dugu klase laguntzaile hau


public class Laguntzailea {

    private String target;
    private String string;
    private String version;
    private String target_id;

    public Laguntzailea(String target, String string, String version, String target_id) {
        this.target = target;
        this.string = string;
        this.version = version;
        this.target_id = target_id;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getTarget() {
        return target;
    }

    public String getString() {
        return string;
    }

    public String getVersion() {
        return version;
    }

    public String getTarget_id() {
        return target_id;
    }
}
