/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Worker;



/**
 *
 * @author This PC
 */
public class Validation {
    private final static Scanner sc= new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int check= Integer.parseInt(sc.nextLine().trim());
                if(check < min || check > max)
                    throw new Exception();
                else return check;             
            }catch(Exception e){
                System.out.println("Please input number in range ["+min+", "+max+"]!");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public String checkInputString() {
        while (true) {
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }
    
    public int checkInputAge(){
        while(true){
            System.out.print("Enter Age: ");
            String s= checkInputString();
            try{
                int number= Integer.parseInt(s);
                if(number>=18 && number<=50){
                    return number;
                }else{
                    System.err.println("Age must be in range 18 to 50!");
                    continue;
                }
                
            }catch(Exception e){
                System.err.println("Just enter number!");
                continue;
            }
        }
    }
    
    public double checkInputSalary(){
        while(true){
            System.out.print("Enter Salary: ");
            String s= checkInputString();
            try{
                double number= Double.parseDouble(s);
                if(number>0){
                    return number;
                }else{
                    System.err.println("Salary must be greater than 0!");
                    continue;
                }                
            }catch(Exception e){
                System.err.println("Just enter number!");
                continue;
            }
        }
    }
           
    public boolean checkInputYesNo(){
        while(true){
            String result= checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }else if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }   
    }
    
    
    
    public boolean checkIdExist(ArrayList<Worker> list, String id){
        for (Worker worker : list) {
            if(worker.getId().equalsIgnoreCase(id)){
                System.err.println("Id exist in list!");
                return true;
            }
        }
        return false;
    }
    
    
}