package ehu.isad.model;

public class Laguntzailea {
    private String url;
    private String cms;
    private String version;
    private String lastUp;

    public Laguntzailea(String url, String cms, String version, String lastUp) {
        this.url = url;
        this.cms = cms;
        this.version = version;
        this.lastUp = lastUp;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setLastUp(String lastUp) {
        this.lastUp = lastUp;
    }

    public String getUrl() {
        return url;
    }

    public String getCms() {
        return cms;
    }

    public String getVersion() {
        return version;
    }

    public String getLastUp() {
        return lastUp;
    }
}
