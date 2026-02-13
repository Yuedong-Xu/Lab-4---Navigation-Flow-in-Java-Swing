package Model;

import java.awt.Image;
import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String hobby;
    private String continent;
    private Image photo;
    private Date dob;

    public User(String firstName, String lastName, int age, String email, String phone, String hobby, String continent, Image photo, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.hobby = hobby;
        this.continent = continent;
        this.photo = photo;
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public Image getPhoto() { return photo; }
    public void setPhoto(Image photo) { this.photo = photo; }

    @Override
public String toString() {
    return "User Details:\n"
            + "Name: " + firstName + " " + lastName + "\n"
            + "Age: " + age + "\n"
            + "Email: " + email + "\n"
            + "Phone: " + phone + "\n"
            + "Hobby: " + hobby + "\n"
            + "Continent: " + continent + "\n";
}

}
