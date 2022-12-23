package dard_o_darman;

import java.io.Serializable;

public class Drug implements Serializable {

    static int DID = 0;
    private int did;
    private String name;
    private String company;
    private String illness;
    private String makeDate;
    private String expireDate;
    private String description;



    public Drug(String name, String company, String illness, String makeDate, String expireDate, String description) {
        this.name = name;
        this.company = company;
        this.illness = illness;
        this.makeDate = makeDate;
        this.expireDate = expireDate;
        this.description = description;
        DID++;
        this.did = DID;
    }


    public static int getDID() {
        return DID;
    }

    public static void setDID(int DID) {
        Drug.DID = DID;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "did=" + did +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", illness='" + illness + '\'' +
                ", makeDate='" + makeDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


/*

    public void save(){
        File.save(this);
    }

    public void remove(){
        File.remove(this);
    }

*/

}
