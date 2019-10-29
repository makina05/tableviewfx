package ehu.isad.model;

public class Person {
 
   private Long id;
   private String userName;
   private String email;
   private boolean active;
 
   public Person(Long id, String userName, String email, boolean active) {
       this.id = id;
       this.userName = userName;
       this.email = email;
       this.active = active;
   }
 
   public Long getId() {
       return id;
   }
 
   public void setId(Long id) {
       this.id = id;
   }
 
   public String getUserName() {
       return userName;
   }
 
   public void setUserName(String userName) {
       this.userName = userName;
   }
 
   public String getEmail() {
       return email;
   }
 
   public void setEmail(String email) {
       this.email = email;
   }

   public boolean isActive() {
       return active;
   }
 
   public void setActive(boolean active) {
       this.active = active;
   }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}