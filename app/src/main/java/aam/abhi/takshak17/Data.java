package aam.abhi.takshak17;

/**
 * Created by user on 9/21/2017.
 */

public class Data {
    private String id;
    private String userID;
    private String Name;
    private String userEmail;
    private String userNumber;
    public String getid() { return this.id; }
    public void setid(String id) { this.id = id; }
    public String getuserID() { return this.userID; }
    public void setuserID(String userID) { this.userID = userID; }
    public String getName() {return this.Name;}
    public void setName(String Name) {this.Name=Name;}
    public String getuserEmail() {return this.userEmail;}
    public void setuserEmail(String userEmail) {this.userEmail=userEmail;}

    public String getuserNumber() {
        return userNumber;
    }

    public void setuserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
