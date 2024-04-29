package Blockchain;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UserData {
    private String username;
    private String name; // Changed from Name to name
    private String gmail;
    private int contactNumber; // Changed from ContactNumber to contactNumber
    private Date dob;
    private String encryptedPassword;

    public UserData(String username, String name, String gmail, int contactNumber, Date dob, String encryptedPassword) {
        this.username = username;
        this.name = name;
        this.gmail = gmail;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.encryptedPassword = encryptedPassword;
    }

    public String toSingleHashString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return username + name + gmail + contactNumber + sdf.format(dob) + encryptedPassword;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getGmail() {
        return gmail;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public Date getDob() {
        return dob;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
