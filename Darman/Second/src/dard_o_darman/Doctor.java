package dard_o_darman;

public class Doctor extends Person  {

    static int DRID = 0;
    protected int drid;
    protected int medicalCode;
    protected String specialty;

    public Doctor(String name, String specialty, int nationalCode, int medicalCode){
        super(name, nationalCode);
        this.medicalCode = medicalCode;
        this.specialty = specialty;
        DRID++;
        this.drid = DRID;
    }


    public static int getDRID() {
        return DRID;
    }

    public static void setDRID(int DRID) {
        Doctor.DRID = DRID;
    }

    public int getDrid() {
        return drid;
    }

    public void setDrid(int drid) {
        this.drid = drid;
    }

    public int getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(int medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "drid=" + drid +
                ", medicalCode=" + medicalCode +
                ", specialty='" + specialty + '\'' +
                ", name='" + name + '\'' +
                ", nationalCode=" + nationalCode +
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
