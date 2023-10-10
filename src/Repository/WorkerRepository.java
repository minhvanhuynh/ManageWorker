/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.WorkerDao;
import java.util.ArrayList;
import model.Worker;

/**
 *
 * @author This PC
 */
public class WorkerRepository implements IWorkerRepository{

    @Override
    public void addWorker(ArrayList<Worker> workers) {
        WorkerDao.Instance().addWorker(workers);
    }

    @Override
    public void changeSalary(ArrayList<Worker> workers, String status) {
        WorkerDao.Instance().changeSalary(workers, status);
    }    

    @Override
    public void display(ArrayList<Worker> workers) {
        WorkerDao.Instance().displayInformationSalary();
    }
    
}
