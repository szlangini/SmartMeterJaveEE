package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    // @GeneratedValue
    Long id;
    private String name;
    private Date signingDate;
    private List<Ablesung> ablesungen;
 
    // Constructors:
 
    public User(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }
    
    @Id
    public Long getId(){return this.id;}

    
    @Column(name="Name")
    public String getName() {
		return name;
	}

    @Column(name="createdAt")
	public Date getSigningDate() {
		return signingDate;
	}
    
    @OneToMany(mappedBy="ablesenderUser")
    public List<Ablesung> getAblesungen(){
    	return ablesungen;
    }
    
    public void setAblesungen(List<Ablesung> newValue){
    	this.ablesungen = newValue;
    }


	// String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}