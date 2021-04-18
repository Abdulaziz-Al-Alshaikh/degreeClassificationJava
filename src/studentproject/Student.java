/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentproject;

/**
 *
 * @author Abdulaziz Al-Alshaikh>
 */
public class Student {
    private int id;
    private String name;
    private double gpa;
    private String major;
    
    public Student(int id, String name, double gpa, String major) {
        this.id=id;
        this.name=name;
        this.gpa=gpa;
        this.major=major;
    }
    public Student() {
        this(0, null, 0.0, null);
    }
    
    public Student(Student other) {
        this(other.getId(), other.getName(), other.getGpa(), other.getMajor());
    }
    
    public int getId() {
        return(this.id);
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getName() {
        return(this.name);
    }
    public void setName(String name) {
        this.name=name;
    }
    public double getGpa() {
        return(this.gpa);
    }
    public void setGpa(double gpa) {
        this.gpa=gpa;
    }
    public String getMajor() {
        return(this.major);
    }
    public void setMajor(String major) {
        this.major=major;
    }
    @Override
    public String toString() {
        return("Student("+this.id+", "+this.name+", "+this.gpa+", "+this.major+")");
    }
    @Override
    public boolean equals(Object other) {
        if(other==null)
            throw new NullPointerException("There is no object referred");
        if(other.getClass().getName().equals("test_student_practice.Student")){
            Student downC = (Student)other;
            return(this.id==downC.getId());
            
        }
        else
            throw new ClassCastException("Object is of different type!");
    }
    @Override
    public int hashCode() {
        return(this.id>>>2 & this.name.hashCode()<<3 ^ (int)this.gpa>>1 | this.major.hashCode()>>3);
    }
}
