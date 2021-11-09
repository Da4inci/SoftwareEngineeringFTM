package org.hbrs.se1.ws21.uebung4.prototype;

public class Employee implements java.io.Serializable, Comparable<Employee> {

    public Employee(int pid, String vorname, String name, String rolle, String abteilung, String expertise, Integer expertisewert) {
        this.pid = pid;
        this.vorname = vorname;
        this.name = name;
        this.rolle = rolle;
        this.abteilung = abteilung;
        this.expertise = expertise;
        this.expertisewert = expertisewert;
    }

    private String vorname;
    private String name;
    private String rolle;
    private Integer pid;
    private String abteilung;
    private String expertise;
    private Integer expertisewert;


    public String getRolle() {return rolle;}

    public void setExpertise(String gebiet) {expertise = gebiet;}

    public void setExpertisewert(Integer expwert) {expertisewert = expwert;}

    public Integer getExpertisewert() {return expertisewert;}
    public String getExpertise() {return expertise;}

    public void setRolle(String rolle) {this.rolle = rolle;}

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String toString() {
        return "|"+pid+"|"+vorname+"|"+name+"|"+rolle+"|"+abteilung+"|"+expertise+"|";
    }

    @Override
    public int compareTo(Employee o) {
        return this.pid - o.pid;  // Werte: 0,1,-1 hier wird der PiD verglichen!
    }

}

