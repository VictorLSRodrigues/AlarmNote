package model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Note implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    @Column(columnDefinition = "smallint default 0")
    private int alarm;
    
    private Timestamp dateTimeAlarm;

    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public  String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public int getAlarm(){
        return alarm;
    }
    
    public void setAlarm(int alarm){
        this.alarm = alarm;
    }
    
    public void setDateTimeAlarm(Timestamp dateTimeAlarm){
        this.dateTimeAlarm = dateTimeAlarm;
   
    }
    
    public Timestamp getDateTimeAlarm(){
        return dateTimeAlarm;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public long getId() {
           return id;
    }
    
    
    
   
}
