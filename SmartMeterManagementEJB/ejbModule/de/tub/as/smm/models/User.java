
package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    private Date signingDate;
    private List<Ablesung> ablesungen;
 
    // Constructors:
 
    public User(){
        this.name = "Unknown";
        this.signingDate = new Date(System.currentTimeMillis());
        this.id = (long) (100 + (Math.random() * 1000000));

    }
    
    public User(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
        this.id = (long) (100 + (Math.random() * 1000000));
    }
    public void setName(String name) {
		this.name = name;
	}
    
    
   @Id
    public Long getId(){return this.id;}
   public void setId(Long id){ this.id = id;}

	@Column(name="Name")
    public String getName() {
		return name;
	}

    @Column(name="createdAt")
	public Date getSigningDate() {
		return signingDate;
	}
    
    public void setSigningDate(Date signingDate) {
		this.signingDate = signingDate;
	}
	@OneToMany(mappedBy="user")
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