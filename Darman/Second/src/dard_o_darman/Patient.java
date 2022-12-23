package dard_o_darman;

public class Patient extends Person  {

    static int PID = 0;
    protected int pid;
    protected String illness;

    public Patient(String name, int nationalCode, String illness) {
        super(name, nationalCode);
        this.illness = illness;
        PID++;
        this.pid = PID;
    }


    public static int getPID() {
        return PID;
    }

    public static void setPID(int PID) {
        Patient.PID = PID;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pid=" + pid +
                ", illness='" + illness + '\'' +
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
