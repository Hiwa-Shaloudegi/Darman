package dard_o_darman;

import java.io.Serializable;

public class Person implements Serializable {

    protected String name;
    protected int nationalCode;

    public Person(String name, int nationalCode){
        this.name = name;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nationalCode=" + nationalCode +
                '}';
    }

}
