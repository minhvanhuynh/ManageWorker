/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.net.Socket;
import java.util.Date;

/**
 *
 * @author This PC
 */
public class HistorySalary {
    private Worker worker;
    private String status;
    private Date date;

    public HistorySalary(Worker worker, String status, Date date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-13s%-13s%-13s%-13s%-13s%-13s", worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), getStatus(), ( (date.getDate()+1)+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900) ) );
    }
    
    
}
