package com.carlos.cartracking.model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name="CAR")
public class Car {

    // This is the model for our database, or a POJO, (Plain old Java Object) Java Bean or Bean

    // Every model has an ID, as this will give items in the database unique identifiers
    // Every property represents a column in the database
    // We set the generated type of id to auto, as we want it to auto increment each type a new items added to Database

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "CARPART")
    private String carpart;
    @Column(name = "WORK_UNDERTAKEN")
    private String workUndertaken;
    @Column(name = "HOURS_SPENT")
    private String hoursSpent;
    @Column(name = "RESOUTION_COMMENTS")
    private String resoutionComments;

    // Intellij will automatically generate getters and setters, they aren't 100% required
    // But will make it easier when working with our services we created to interact with the database.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarpart() {
        return carpart;
    }

    public void setCarpart(String carpart) {
        this.carpart = carpart;
    }

    public String getWorkUndertaken() {
        return workUndertaken;
    }

    public void setWorkUndertaken(String workUndertaken) {
        this.workUndertaken = workUndertaken;
    }

    public String getHoursSpent() {
        return hoursSpent;
    }

    public void setHoursSpent(String hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public String getResoutionComments() {
        return resoutionComments;
    }

    public void setResoutionComments(String resoutionComments) {
        this.resoutionComments = resoutionComments;
    }
}