package dard_o_darman;

import java.io.Serializable;

public class Visit implements Serializable {

    static int VID = 0;
    private int vid;
    private Doctor doctor;
    private Patient patient;
    private Drug drug;
    private String date;

    public Visit(Doctor doctor,Patient patient, Drug drug, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.drug = drug;
        this.date = date;
        VID++;
        this.vid = VID;
    }

    public static int getVID() {
        return VID;
    }

    public static void setVID(int VID) {
        Visit.VID = VID;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "vid=" + vid +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", drug=" + drug +
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
