/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import java.util.ArrayList;
import java.util.Date;
import model.HistorySalary;
import model.Worker;
import view.Validation;

/**
 *
 * @author This PC
 */
public class WorkerDao {
    
    private static WorkerDao instance= null;
    private Validation validation;
    private ArrayList<HistorySalary> his_salary;
    
    public WorkerDao(){
        validation= new Validation();
        his_salary= new ArrayList<>();
    }
    
    
    public static WorkerDao Instance(){
        if(instance==null){
            synchronized(WorkerDao.class){
                if(instance==null){
                    instance= new WorkerDao();
                }
            }
        }
        return instance;
    }
    
    public void addWorker(ArrayList<Worker> workers){
        while(true){                                    
            System.out.print("Enter Name: ");
            String name= validation.checkInputString();
            int age= validation.checkInputAge();
            double salary= validation.checkInputSalary();
            System.out.println("Enter work location: ");
            String workLocation= validation.checkInputString();
            Worker worker= new Worker(workers.size()+1+"", name, age, salary, workLocation);
            workers.add(worker);
            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            if(!validation.checkInputYesNo()){
                return;
            }            
        }
    }
    
    public void changeSalary(ArrayList<Worker> workers, String status){
        System.out.print("Enter Code: ");
        String code= validation.checkInputString();
        Worker work_new=null;
        for (Worker worker : workers) {
            if(worker.getId().equalsIgnoreCase(code)){                
                double salary= validation.checkInputSalary();
                if(status.equalsIgnoreCase("up")){
                    
                    work_new= new Worker(worker.getId(), worker.getName(), worker.getAge(), (worker.getSalary()+salary), worker.getWorkLocation());
                    worker.setSalary(work_new.getSalary());
                }else if(status.equalsIgnoreCase("down")){
                    if(salary>=worker.getSalary()){
                        System.err.println("Don't more than salary current!");
                        return;
                    }
                    work_new= new Worker(worker.getId(), worker.getName(), worker.getAge(), (worker.getSalary()-salary), worker.getWorkLocation());
                    worker.setSalary(work_new.getSalary());
                }
                Date date= new Date();
                HistorySalary hs= new HistorySalary(work_new, status, date);
                his_salary.add(hs);
                break;
            }
        }
        if(his_salary.isEmpty()){
            System.err.println("Code no exist!");
        }
    }
    
    public void displayInformationSalary(){
        System.out.println("--------Display Information Salary--------");
        System.out.println(String.format("%-13s%-13s%-13s%-13s%-13s%-13s","Code","Name", "Age","Salary","Status","Date"));
        for (HistorySalary historySalary : his_salary) {
            System.out.println(historySalary);
        }
    }
}
