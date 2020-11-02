package ehu.isad.model;

import javafx.scene.image.Image;

import java.net.Inet4Address;

public class HerrialdeModel {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer puntuakId;
    private Image image;
    private String imagePath;

    public HerrialdeModel(Integer puntuakId, Integer studentId, String firstName, String lastName, String imagePath) {
        this.puntuakId = puntuakId;
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = new Image(imagePath);
    }

    public int getStudentId() {
        return studentId;
    }

    public int getPuntuakId(){ return puntuakId; }

    public void setPuntuakId(int puntuakId){this.puntuakId = puntuakId;}

    public void setStudentId(int studentId) {this.studentId = studentId;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}