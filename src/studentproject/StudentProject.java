/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentproject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Abdulaziz Al-Alshaikh>
 */
public class StudentProject {

    public static void main(String[] args) throws IOException {
        HashSet <Student> students = new HashSet<Student> (200, 0.85f);
        Scanner readFile = new Scanner(new File("students.txt"));
        
        int [] majorCounter = new int [3];
        while(readFile.hasNext()){
            String readLine=readFile.nextLine();
            String [] studentsData=readLine.split("#");
            students.add(new Student(Integer.parseInt(studentsData[0]), studentsData[1], Double.parseDouble(studentsData[2]), studentsData[3]));
            if(studentsData[3].equals("CS"))
                majorCounter[0]++;
            else if(studentsData[3].equals("SE"))
                majorCounter[1]++;
            else if(studentsData[3].equals("IS"))
                majorCounter[2]++;
        }
        readFile.close();
        
        System.out.println("Total number of students found in the file is "+(majorCounter[0]+majorCounter[1]+majorCounter[2]));
        System.out.println("Total number of students found in the hash set is "+students.size());
        
        for (int i = 0; i < majorCounter.length; i++) 
            majorCounter[i]=0;
        
        
        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()){
            Student st = iter.next();
            if(st.getMajor().equals("CS"))
                majorCounter[0]++;
            else if(st.getMajor().equals("SE"))
                majorCounter[1]++;
            else if(st.getMajor().equals("IS"))
                majorCounter[2]++;
        }
        
        System.out.printf("number of students in the CS major is %d and the number of students in the SE major is %d and the number of students in the IS major is %d",majorCounter[0],majorCounter[1],majorCounter[2]);
        double lowestGpaSe=Double.MAX_VALUE;
        double highestGpaCs=Double.MIN_VALUE;
        double totalIsStudents=0;
        iter = students.iterator();
        while(iter.hasNext()){
            Student st = iter.next();
            if(st.getMajor().equals("CS"))
                if(highestGpaCs<st.getGpa())
                    highestGpaCs=st.getGpa();
            if(st.getMajor().equals("SE"))
                if(lowestGpaSe>st.getGpa())
                    lowestGpaSe=st.getGpa();
            if(st.getMajor().equals("IS"))
                totalIsStudents+=st.getGpa();
        }
        System.out.printf("\nHighest GPA of the CS students is %.4f and the lowest GPA of the SE students is %.4f and the average GPA of"
                + " the IS students is %.4f\n",highestGpaCs,lowestGpaSe,totalIsStudents/majorCounter[2]);
        iter = students.iterator();
        while(iter.hasNext()){
            Student st = iter.next();
            if(st.getGpa()<2)
                iter.remove();
        }
        System.out.println("The new total of students is "+students.size());
        iter = students.iterator();
        int id=2020917;
        int hash=0;
        while(iter.hasNext()){
            Student st = iter.next();
            if(st.getId()==id)
                hash=st.hashCode();
        }
        
        if(hash!=0)
            System.out.printf("The HashSet contains the student with ID %d, and the hash code is %d", id, hash);
        else
            System.out.println("No student found with the ID: "+id);
        
        HashMap <Student, String> hash_map = new HashMap<Student, String>();
        int firstHonors =0;
        int secondHonors =0;
        int thirdHonors =0;
        int normalStanding =0;
        int warning =0;
        iter = students.iterator();
        while(iter.hasNext()){
            Student st = iter.next();
            if(st.getGpa()>=3.75){
                firstHonors++;
                hash_map.put(st, "First Honor!");
            }
            else if(st.getGpa()<3.75 & st.getGpa()>=3.25){
                secondHonors++;
                hash_map.put(st, "Second Honor!");
            }
            else if(st.getGpa()<3.25 & st.getGpa()>=3){
                thirdHonors++;
                hash_map.put(st, "Third Honor!");
            }
            else if(st.getGpa()<3 & st.getGpa()>=2){
                normalStanding++;
                hash_map.put(st, "Normal Standing");
            }
            else{
                warning++;
                hash_map.put(st, "Warning!");
            }
                
        }
        
        System.out.printf("The number of students with first honors standing is %d\nThe number of students with second honors"
                          + " standing is %d\nThe number of students with third honors standing is %d\nThe number of students with "
                          + "normal standing is %d\nThe number of students with warning standing is %d\n",
                            firstHonors,secondHonors,thirdHonors,normalStanding,warning );
        System.out.println(hash_map);
    }
    
}


