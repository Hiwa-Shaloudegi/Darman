package dard_o_darman;

import java.io.*;
import java.util.ArrayList;

public class File {

    private static final String doctorPath = "J:\\file\\doctor.txt";
    private static final String patientPath = "J:\\file\\patient.txt";
    private static final String drugPath = "J:\\file\\drug.txt";
    private static final String messagePath = "J:\\file\\message.txt";
    private static final String visitPath = "J:\\file\\visit.txt";

/////////////////////////////////////////////////////////////////////////

    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Visit> visits = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();
    public static ArrayList<Drug> drugs = new ArrayList<>();

/////////////////////////////////////////////////////////////////////////

    public static void save(Doctor doctor) {
        doctors.add(doctor);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(doctorPath)) ){

            for (Doctor d : doctors) {
                out.writeObject(d);
            }
            out.close();

            System.out.println("Saved");


        } catch (IOException e){
            e.printStackTrace();
        }

    } //*****************

    public static void save(Patient patient){

        patients.add(patient);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(patientPath)) ){

            for (Patient p : patients) {
                out.writeObject(p);
            }
            out.close();

            System.out.println("Saved");


        } catch (IOException e){
            e.printStackTrace();
        }

    } //*****************

    public static void save(Drug drug){
        drugs.add(drug);


        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(drugPath)) ){

            for (Drug d : drugs) {
                out.writeObject(d);
            }
            out.close();

            System.out.println("Saved");


        } catch (IOException e){
            e.printStackTrace();
        }
    } //*****************

    public static void save(Message message){
        messages.add(message);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(messagePath)) ){

            for (Message m : messages) {
                out.writeObject(m);
            }
            out.close();

            System.out.println("Saved");


        } catch (IOException e){
            e.printStackTrace();
        }
    } //*****************

    public static void save(Visit visit){
        visits.add(visit);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(visitPath)) ){

            for (Visit v : visits) {
                out.writeObject(v);
            }
            out.close();

            System.out.println("Saved");


        } catch (IOException e){
            e.printStackTrace();
        }
    } //*****************


////////////////////////////////////////////////////////////////

/*
    public static void remove(Doctor doctor){

        //doctors.remove(doctor);

        doctors.clear();

        //////////////////////

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(doctorPath))){

            while(true){
                Doctor d = (Doctor) in.readObject();
                doctors.add(d);
            }


        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }

        /////////////////////


        doctors.remove(doctor);


        /////////////////////


        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(doctorPath)) ){

            for (Doctor d : doctors) {
                out.writeObject(d);
            }
            out.close();

            System.out.println("Removed");


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void remove(Patient patient){

        //patients.clear();
        /////////////////////////////////

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(patientPath))){

            while(true){
                Patient p = (Patient) in.readObject();
                patients.add(p);
            }


        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }


        /////////////////////////////////

        patients.remove(patient);

        ////////////////////////////////

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(patientPath)) ){

            for (Patient p : patients) {
                out.writeObject(p);
            }
            out.close();

            System.out.println("Removed");


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void remove(Drug drug){
        drugs.remove(drug);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(drugPath)) ){

            for (Drug d : drugs) {
                out.writeObject(d);
            }
            out.close();

            System.out.println("Done");


        } catch (IOException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    public static void remove(Message message){
        messages.remove(message);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(messagePath)) ){

            for (Message m : messages) {
                out.writeObject(m);
            }
            out.close();

            System.out.println("Done");


        } catch (IOException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    public static void remove(Visit visit){
        visits.remove(visit);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(visitPath)) ){

            for (Visit v : visits) {
                out.writeObject(v);
            }
            out.close();

            System.out.println("Done");


        } catch (IOException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
*/


////////////////////////////////////////////////////////////////

    public static void showDoctors(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(doctorPath))){

            while(true){
                Doctor d = (Doctor) in.readObject();
                System.out.println(d.toString());
            }


        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    } //*****************

    public static void showPatients(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(patientPath))){

            while (true){
                Patient p = (Patient) in.readObject();
                System.out.println(p.toString());
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    } //*****************

    public static void showDrugs(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(drugPath))){

            while (true){
                Drug d = (Drug) in.readObject();
                System.out.println(d.toString());
            }

        } catch (IOException e){
            System.out.println("End of file");

        } catch (ClassNotFoundException ce){
            ce.printStackTrace();

        }

    } //*****************

    public static void showMessages(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(messagePath))){

            while (true) {
                Message m = (Message) in.readObject();
                System.out.println(m.toString());
            }


        } catch (IOException e){
            System.out.println("End of file");

        } catch (ClassNotFoundException ce){
            ce.printStackTrace();

        }
    } //*****************

    public static void showVisits(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(visitPath))){

            while (true){
                Visit v = (Visit) in.readObject();
                System.out.println(v.toString());
            }

        } catch (IOException e){
            System.out.println("End of file");

        } catch (ClassNotFoundException ce){
            ce.printStackTrace();

        }

    } //*****************


////////////////////////////////////////////////////////////////

    public static Doctor searchDoctor(int id) {

        Doctor doctor = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(doctorPath))) {

            while (true) {
                Doctor d = (Doctor) in.readObject();
                if (d.getDrid() == id) {
                    doctor = d;
                    break;
                }
            }


        } catch (EOFException eof) {
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return doctor;


    } //*****************


    public static Patient searchPatient(int id){

        Patient patient = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(patientPath))) {

            while (true) {
                Patient p = (Patient) in.readObject();
                if (p.getPid() == id) {
                    patient = p;
                    break;
                }
            }


        } catch (EOFException eof) {
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return patient;
    } //*****************


    public static Drug searchDrug(int id){

        Drug drug = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(drugPath))) {

            while (true) {
                Drug d = (Drug) in.readObject();
                if (d.getDid() == id) {
                    drug = d;
                    break;
                }
            }


        } catch (EOFException eof) {
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return drug;

    } //*****************


    public static Message searchMessage(int id){

        Message message = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(messagePath))) {

            while (true) {
                Message m = (Message) in.readObject();
                if (m.getMid() == id) {
                    message = m;
                    break;
                }
            }


        } catch (EOFException eof) {
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return message;

    } //*****************


    public static Visit searchVisit(int id){

        Visit visit = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(visitPath))) {

            while (true) {
                Visit v = (Visit) in.readObject();
                if (v.getVid() == id) {
                    visit = v;
                    break;
                }
            }


        } catch (EOFException eof) {
            System.out.println("End of file");

        } catch (IOException | ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return visit;
    } //*****************



}
