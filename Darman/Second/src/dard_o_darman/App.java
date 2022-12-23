package dard_o_darman;

import java.io.*;
import java.util.Scanner;

public class App {


    public static void addDoctor(){

        try{
            Scanner scanner = new Scanner(System.in);
            Scanner scannerInt = new Scanner(System.in);

            System.out.println("Enter the name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the national code: ");
            int nationalCode = scannerInt.nextInt();

            System.out.println("Enter the specialty: ");
            String specialty = scanner.nextLine();

            System.out.println("Enter the medical code: ");
            int medicalCode = scannerInt.nextInt();

            ////////////////////////////////
            File.doctors.clear();
            ////////////////////////////////

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\doctor.txt"))){

                while(true){
                    Doctor d =(Doctor) in.readObject();
                    File.doctors.add(d);
                }

            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }


            ////////////////////////////////
            if(!File.doctors.isEmpty()){
                int lastOne = File.doctors.size() - 1;
                Doctor.DRID = File.doctors.get(lastOne).drid;
            }

            Doctor doctor = new Doctor(name, specialty, nationalCode, medicalCode);

            File.save(doctor);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void addPatient(){

        try{
            Scanner scanner = new Scanner(System.in);
            Scanner scannerInt = new Scanner(System.in);


            System.out.println("Enter the name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the national code: ");
            int nationalCode = scannerInt.nextInt();

            System.out.println("Enter the illness: ");
            String illness = scanner.nextLine();


            ////////////////////////////////
            File.patients.clear();
            //////////////////////////////// read --> patents

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\patient.txt"))){

                while(true){
                    Patient p = (Patient) in.readObject();
                    File.patients.add(p);
                }

            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            ////////////////////////////////
            if(!File.patients.isEmpty()){
                int lastOne = File.patients.size() - 1;
                Patient.PID = File.patients.get(lastOne).pid;
            }

            Patient patient = new Patient(name, nationalCode, illness);

            File.save(patient);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    } //*****************


    public static void addDrug(){

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the company: ");
            String company = scanner.nextLine();

            System.out.println("Enter the illness: ");
            String illness = scanner.nextLine();

            System.out.println("Enter the make date: ");
            String makeDate = scanner.nextLine();

            System.out.println("Enter the expire date: ");
            String expireDate = scanner.nextLine();

            System.out.println("Enter the description: ");
            String description = scanner.nextLine();

            ////////////////////////////////
            File.drugs.clear();
            ////////////////////////////////

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\drug.txt"))){

                while(true){
                    Drug d = (Drug) in.readObject();
                    File.drugs.add(d);
                }

            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            ////////////////////////////////
            if(!File.drugs.isEmpty()){
                int lastOne = File.drugs.size() - 1;
                Drug.DID = File.drugs.get(lastOne).getDid();
            }

            Drug drug = new Drug(name, company, illness, makeDate, expireDate, description);

            File.save(drug);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void addVisit(){

        try {
            Scanner scanner = new Scanner(System.in);
            Scanner scannerInt = new Scanner(System.in);


            System.out.println("Enter the date : ");
            String date = scanner.nextLine();

            File.showDoctors();
            System.out.println("Enter doctor id: ");
            int drid = scannerInt.nextInt();
            Doctor doctor = File.searchDoctor(drid);
            System.out.println();


            File.showPatients();
            System.out.println("Enter patient id: ");
            int pid = scannerInt.nextInt();
            Patient patient = File.searchPatient(pid);
            System.out.println();


            File.showDrugs();
            System.out.println("Enter drug id: ");
            int did = scannerInt.nextInt();
            Drug drug = File.searchDrug(did);
            System.out.println();

            ////////////////////////////////
            File.visits.clear();
            ////////////////////////////////

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\visit.txt"))){

                while(true){
                    Visit v = (Visit) in.readObject();
                    File.visits.add(v);
                }

            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            ////////////////////////////////
            if(!File.visits.isEmpty()){
                int lastOne = File.visits.size() - 1;
                Visit.VID = File.visits.get(lastOne).getVid();
            }


            Visit visit = new Visit(doctor, patient, drug, date);

            //Message.visited = true;

            File.save(visit);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void addMessage(){

        try {
            Scanner scanner = new Scanner(System.in);
            Scanner scannerInt = new Scanner(System.in);


            System.out.println("Enter the subject: ");
            String subject = scanner.nextLine();

            System.out.println("Enter the date: ");
            String date = scanner.nextLine();

            File.showDoctors();
            System.out.println("Enter doctor id: ");
            int drid = scannerInt.nextInt();
            Doctor doctor = File.searchDoctor(drid);
            System.out.println();

            File.showPatients();
            System.out.println("Enter patient id: ");
            int pid = scannerInt.nextInt();
            Patient patient = File.searchPatient(pid);
            System.out.println();


/*
            System.out.println("IS VISITED: ");
            boolean visited = scanner.nextBoolean();
*/

            ////////////////////////////////
            File.messages.clear();
            ////////////////////////////////

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\message.txt"))){

                while(true){
                    Message m = (Message) in.readObject();
                    File.messages.add(m);
                }

            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            ////////////////////////////////
            if(!File.messages.isEmpty()){
                int lastOne = File.messages.size() - 1;
                Message.MID = File.messages.get(lastOne).getMid();
            }

            Message message = new Message(doctor, patient, subject, date);

            File.save(message);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


////////////////////////////////////////////////////////////////


    public static void removeDoctor(){

        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter doctor id: ");
            File.showDoctors();
            int id = scanner.nextInt();


            ///////////////////////////////////////////////////////// Delete doctor

            File.doctors.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\doctor.txt"))){

                while(true){
                    Doctor d = (Doctor) in.readObject();
                    File.doctors.add(d);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }



            ///////////////////////////
            for (Doctor d : File.doctors) {
                if(d.getDrid() == id){
                    File.doctors.remove(d);
                    break;
                } else {
                    System.out.println("Already deleted");
                }

            }
            ///////////////////////////

            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\doctor.txt")) ){

                for (Doctor d : File.doctors) {
                    out.writeObject(d);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }

            ///////////////////////////////////////////////////////// Delete message

            File.messages.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\message.txt"))){

                while(true){
                    Message m = (Message) in.readObject();
                    File.messages.add(m);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            for (Message m : File.messages) {
                if(m.getDoctor().getDrid() == id){
                    File.messages.remove(m);
                }
            }


            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\message.txt")) ){

                for (Message m : File.messages) {
                    out.writeObject(m);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }


            ///////////////////////////////////////////////////////// Delete visit

            File.visits.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\visit.txt"))){

                while(true){
                    Visit v = (Visit) in.readObject();
                    File.visits.add(v);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }


            for (Visit v : File.visits) {
                if(v.getDoctor().getDrid() == id){
                    File.messages.remove(v);
                }
            }


            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\visit.txt")) ){

                for (Visit v : File.visits) {
                    out.writeObject(v);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void removePatient(){

        try{
            Scanner scannerInt = new Scanner(System.in);

            System.out.println("Enter patient id: ");
            File.showPatients();
            int id = scannerInt.nextInt();

            ///////////////////////////////////////////////////////// Delete patient

            File.patients.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\patient.txt"))){

                while(true){
                    Patient p = (Patient) in.readObject();
                    File.patients.add(p);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }



            ///////////////////////////
            for (Patient p : File.patients) {
                if(p.getPid() == id){
                    File.patients.remove(p);
                    break;
                } else {
                    System.out.println("Already deleted");
                }

            }
            ///////////////////////////

            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\patient.txt")) ){

                for (Patient p : File.patients) {
                    out.writeObject(p);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }


            ///////////////////////////////////////////////////////// Delete message

            File.messages.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\message.txt"))){

                while(true){
                    Message m = (Message) in.readObject();
                    File.messages.add(m);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            for (Message m : File.messages) {
                if(m.getPatient().getPid() == id){
                    File.messages.remove(m);
                }
            }


            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\message.txt")) ){

                for (Message m : File.messages) {
                    out.writeObject(m);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }


            ///////////////////////////////////////////////////////// Delete visit

            File.visits.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\visit.txt"))){

                while(true){
                    Visit v = (Visit) in.readObject();
                    File.visits.add(v);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }


            for (Visit v : File.visits) {
                if(v.getPatient().getPid() == id){
                    File.messages.remove(v);
                }
            }


            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\visit.txt")) ){

                for (Visit v : File.visits) {
                    out.writeObject(v);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void removeDrug(){

        try{
            Scanner scannerInt = new Scanner(System.in);

            System.out.println("Enter drug id: ");
            File.showDrugs();
            int id = scannerInt.nextInt();

            ///////////////////////////////////////////////////////// Delete drug

            File.drugs.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\drug.txt"))){

                while(true){
                    Drug d = (Drug) in.readObject();
                    File.drugs.add(d);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }



            ///////////////////////////
            for (Drug d : File.drugs) {
                if(d.getDid() == id){
                    File.patients.remove(d);
                    break;
                } else {
                    System.out.println("Already deleted");
                }

            }
            ///////////////////////////

            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\drug.txt")) ){

                for (Drug d : File.drugs) {
                    out.writeObject(d);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }


            ///////////////////////////////////////////////////////// Delete visit

            File.visits.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\visit.txt"))){

                while(true){
                    Visit v = (Visit) in.readObject();
                    File.visits.add(v);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }


            for (Visit v : File.visits) {
                if(v.getDrug().getDid() == id){
                    File.messages.remove(v);
                }
            }


            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\visit.txt")) ){

                for (Visit v : File.visits) {
                    out.writeObject(v);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void removeMessage(){

        try{
            Scanner scannerInt = new Scanner(System.in);

            System.out.println("Enter message id: ");
            File.showMessages();
            int id = scannerInt.nextInt();

            ///////////////////////////

            File.messages.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\message.txt"))){

                while(true){
                    Message m = (Message) in.readObject();
                    File.messages.add(m);
                }


            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            ///////////////////////////
            for (Message m : File.messages) {
                if(m.getMid() == id){
                    File.messages.remove(m);
                    break;
                } else {
                    System.out.println("Already deleted");
                }

            }
            ///////////////////////////

            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\message.txt")) ){

                for (Message m: File.messages) {
                    out.writeObject(m);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************


    public static void removeVisit(){

        try{
            Scanner scannerInt = new Scanner(System.in);

            System.out.println("Enter visit id: ");
            File.showVisits();
            int id = scannerInt.nextInt();


            ///////////////////////////

            File.visits.clear();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\visit.txt"))){

                while(true){
                    Visit v = (Visit) in.readObject();
                    File.visits.add(v);
                }

            } catch (EOFException eof){
                System.out.println("End of file");

            } catch (IOException| ClassNotFoundException ce){
                ce.printStackTrace();
            }

            ///////////////////////////
            for (Visit v : File.visits) {
                if(v.getVid() == id){
                    File.visits.remove(v);
                    break;
                } else {
                    System.out.println("Already deleted");
                }

            }
            ///////////////////////////

            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\visit.txt")) ){

                for (Visit v: File.visits) {
                    out.writeObject(v);
                }
                out.close();

                System.out.println("Removed");


            } catch (IOException e){
                e.printStackTrace();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } //*****************

////////////////////////////////////////////////////////////////

    public static void editDoctorName() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("Enter doctor id: ");
        File.showDoctors();
        int id = scannerInt.nextInt();


        System.out.println("Enter the new name: ");
        String name = scanner.nextLine();

        /////////////////////////////
        File.doctors.clear();
        /////////////////////////////
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\doctor.txt"))){

            while(true){
                Doctor d =(Doctor) in.readObject();
                File.doctors.add(d);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }

        ////////////////////////////  SearchDoctor(id)

        for (Doctor d : File.doctors) {
            if(d.getDrid() == id){
                d.setName(name);
                break;
            }
        }
        ////////////////////////////
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\doctor.txt")) ){

            for (Doctor d : File.doctors) {
                out.writeObject(d);
            }
            out.close();

            System.out.println("Edited");


        } catch (IOException e){
            e.printStackTrace();
        }


    } //*****************

    public static void editPatientName(){
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("Enter patient id: ");
        File.showPatients();
        int id = scannerInt.nextInt();


        System.out.println("Enter the new name: ");
        String name = scanner.nextLine();

        /////////////////////////////
        File.patients.clear();
        /////////////////////////////
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\patient.txt"))){

            while(true){
                Patient p =(Patient) in.readObject();
                File.patients.add(p);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }

        ////////////////////////////
        for (Patient p : File.patients) {
            if(p.getPid() == id){
                p.setName(name);
                break;
            }
        }

        ////////////////////////////
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\patient.txt")) ){

            for (Patient p : File.patients) {
                out.writeObject(p);
            }
            out.close();

            System.out.println("Edited");


        } catch (IOException e){
            e.printStackTrace();
        }

    } //*****************

    public static void editDrugName(){
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("Enter drug id: ");
        File.showDrugs();
        int id = scannerInt.nextInt();


        System.out.println("Enter the new name: ");
        String name = scanner.nextLine();

        /////////////////////////////
        File.drugs.clear();
        /////////////////////////////
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\drug.txt"))){

            while(true){
                Drug d =(Drug) in.readObject();
                File.drugs.add(d);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }

        ////////////////////////////
        for (Drug d : File.drugs) {
            if(d.getDid() == id){
                d.setName(name);
                break;
            }
        }

        ////////////////////////////
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\drug.txt")) ){

            for (Drug d : File.drugs) {
                out.writeObject(d);
            }
            out.close();

            System.out.println("Edited");


        } catch (IOException e){
            e.printStackTrace();
        }

    }    //*****************

    public static void editMessage(){

        Scanner scannerInt = new Scanner(System.in);

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select message

        System.out.println("Enter message id: ");
        File.showMessages();
        int id = scannerInt.nextInt();

        File.messages.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\message.txt"))){

            while(true){
                Message m =(Message) in.readObject();
                File.messages.add(m);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }



        Message message = null;
        for (Message m : File.messages) {
            if(m.getMid() == id){
                message = m;
                break;
            }
        }


        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select doctor

        System.out.println("Select new doctor (ID): ");
        File.showDoctors();
        int doctorID = scannerInt.nextInt();

        File.doctors.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\doctor.txt"))){

            while(true){
                Doctor d =(Doctor) in.readObject();
                File.doctors.add(d);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }



        Doctor doctor = null;
        for (Doctor d : File.doctors) {
            if(d.getDrid() == doctorID){
                doctor = d;
                break;
            }
        }

        message.setDoctor(doctor);

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select patient

        System.out.println("Select new patient (ID): ");
        File.showPatients();
        int patentID = scannerInt.nextInt();

        File.patients.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\patient.txt"))){

            while(true){
                Patient p =(Patient) in.readObject();
                File.patients.add(p);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }



        Patient patient = null;
        for (Patient p : File.patients) {
            if(p.getPid() == patentID){
                patient = p;
                break;
            }
        }


        message.setPatient(patient);

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Save edited message in File

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("J:\\file\\message.txt")) ){

            for (Message m : File.messages) {
                out.writeObject(m);
            }
            out.close();

            System.out.println("Edited");


        } catch (IOException e){
            e.printStackTrace();
        }



    } //*****************

    public static void editVisit(){

        Scanner scannerInt = new Scanner(System.in);

        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select visit
        System.out.println("Enter visit id: ");
        File.showVisits();
        int id = scannerInt.nextInt();

        File.visits.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\visit.txt"))){

            while(true){
                Visit v =(Visit) in.readObject();
                File.visits.add(v);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }


        Visit visit= null;
        for (Visit v : File.visits) {
            if(v.getVid() == id){
                visit = v;
                break;
            }
        }



        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select doctor


        System.out.println("Select new doctor (ID): ");
        File.showDoctors();
        int doctorID = scannerInt.nextInt();


        File.doctors.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\doctor.txt"))){

            while(true){
                Doctor d =(Doctor) in.readObject();
                File.doctors.add(d);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }



        Doctor doctor = null;
        for (Doctor d : File.doctors) {
            if(d.getDrid() == doctorID){
                doctor = d;
                break;
            }
        }

        visit.setDoctor(doctor);



        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select patient

        System.out.println("Select new patient (ID): ");
        File.showPatients();
        int patentID = scannerInt.nextInt();


        File.patients.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\patient.txt"))){

            while(true){
                Patient p =(Patient) in.readObject();
                File.patients.add(p);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }



        Patient patient = null;
        for (Patient p : File.patients) {
            if(p.getPid() == patentID){
                patient = p;
                break;
            }
        }

        visit.setPatient(patient);


        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Select Drug

        System.out.println("Select new drug (ID): ");
        File.showDrugs();
        int drugID = scannerInt.nextInt();

        File.drugs.clear();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("J:\\file\\drug.txt"))){

            while(true){
                Drug d =(Drug) in.readObject();
                File.drugs.add(d);
            }

        } catch (EOFException eof){
            System.out.println("End of file");

        } catch (IOException| ClassNotFoundException ce){
            ce.printStackTrace();
        }



        Drug drug = null;
        for (Drug d : File.drugs) {
            if(d.getDid() == drugID){
                drug = d;
                break;
            }
        }


        visit.setDrug(drug);


        //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Save edited visit in File

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream( "J:\\file\\visit.txt"))){

            for (Visit v : File.visits) {
                out.writeObject(v);
            }
            out.close();

            System.out.println("Edited");


        } catch (IOException e){
            e.printStackTrace();
        }

    } //*****************

////////////////////////////////////////////////////////////////


    public static void main(String[] args) {

        while(true){
            try{
                Scanner scannerInt = new Scanner(System.in);

                System.out.println("Main Menu:");
                System.out.println("1: add doctor");
                System.out.println("2: add patient");
                System.out.println("3: add drug");
                System.out.println("4: add message");
                System.out.println("5: add visit");
                System.out.println("----------------");

                System.out.println("6: remove doctor");
                System.out.println("7: remove patient");
                System.out.println("8: remove drug");
                System.out.println("9: remove message");
                System.out.println("10: remove visit");
                System.out.println("----------------");

                System.out.println("11: show doctor");
                System.out.println("12: show patient");
                System.out.println("13: show drug");
                System.out.println("14: show message");
                System.out.println("15: show visit");
                System.out.println("----------------");

                System.out.println("16: edit doctor's name ");
                System.out.println("17: edit patient's name ");
                System.out.println("18: edit drug's name ");
                System.out.println("19: edit message ");
                System.out.println("20: edit visit ");
                System.out.println("----------------");

                System.out.println("21: Exit");

                int n = scannerInt.nextInt();
                switch (n){
                    case 1:
                        addDoctor();
                        break;

                    case 2:
                        addPatient();
                        break;

                    case 3:
                        addDrug();
                        break;

                    case 4:
                        addMessage();
                        break;

                    case 5:
                        addVisit();
                        break;

                    case 6:
                        removeDoctor();
                        break;

                    case 7:
                        removePatient();
                        break;

                    case 8:
                        removeDrug();
                        break;

                    case 9:
                        removeMessage();
                        break;

                    case 10:
                        removeVisit();
                        break;

                    case 11:
                        File.showDoctors();
                        break;

                    case 12:
                        File.showPatients();
                        break;

                    case 13:
                        File.showDrugs();
                        break;

                    case 14:
                        File.showMessages();
                        break;

                    case 15:
                        File.showVisits();
                        break;

                    case 16:
                        editDoctorName();
                        break;

                    case 17:
                        editPatientName();
                        break;

                    case 18:
                        editDrugName();
                        break;

                    case 19:
                        editMessage();
                        break;

                    case 20:
                        editVisit();
                        break;

                    case 21:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please enter the correct number");
                }


            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


    }


}



