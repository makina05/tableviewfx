package ehu.isad.model;

import java.util.Arrays;
import java.util.List;

public class Cms {
    private String cms;

    public String getCms() {
        return cms;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public Cms(String cms) {
        this.cms = cms;
    }
    public List<String> bueltatuCmsIzenak(){
        List<String> cmsList = Arrays.asList("Wordpess", "Drupal", "Joomla","phpMyAdmin");
        return cmsList;
    }
}
