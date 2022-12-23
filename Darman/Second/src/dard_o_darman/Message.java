package dard_o_darman;

import java.io.Serializable;

public class Message implements Serializable {

    static int MID = 0;
    private int mid;
    private Doctor doctor;
    private Patient patient;
    private String subject;
    private String date;
    //private boolean visited = false;


    public Message(Doctor doctor, Patient patient, String subject, String date){
        this.doctor = doctor;
        this.patient = patient;
        this.subject = subject;
        this.date = date;
        //this.visited = visited;
        MID++;
        this.mid = MID;
    }


    public static int getMID() {
        return MID;
    }

    public static void setMID(int MID) {
        Message.MID = MID;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

 /*   public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
*/
    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", subject='" + subject + '\'' +
                ", date='" + date + '\'' +
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
