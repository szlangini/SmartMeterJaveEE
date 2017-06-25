
package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Ablesung implements Serializable {
    private static final long serialVersionUID = 1L;
 
    
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private Date ableseDatum;
    
    private float kwh;
    private User user;
    private Zaehler zaehler;
 
    // Constructors: 
    public Ablesung(){
    	
     this.ableseDatum = new Date(System.currentTimeMillis());
     this.id = (long) (100 + (Math.random() * 1000000));

    }
    
    public Ablesung(User ablesenderUser) {
        this.user = ablesenderUser;
        this.ableseDatum = new Date(System.currentTimeMillis());
        this.id = (long) (100 + (Math.random() * 1000000));

    }
	
    public void setId(Long id) {
		this.id = id;
	}

	public void setAbleseDatum(Date ableseDatum) {
		this.ableseDatum = ableseDatum;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setZaehler(Zaehler zaehler) {
		this.zaehler = zaehler;
	}

	@Id
    public Long getId(){return this.id;}
    
	@Column(name="ableseDatum")
	public Date getAbleseDatum(){return this.ableseDatum;}
    
	
	@ManyToOne()
	@JoinColumn(name="USER_ID")
	public User getUser(){ return this.user;}
	
	// PROBLEM
	@ManyToOne()
	@JoinColumn(name="ZAEHLER_ID")
	public Zaehler getZaehler(){return this.zaehler;}
	
    // String Representation:
    @Override
    public String toString() {
        return this.user.getName() + " (abgelesen am " + this.ableseDatum + ")";
    }

    @Column(name="kwh")
	public float getKwh() {
		return kwh;
	}

	public void setKwh(float kwh) {
		this.kwh = kwh;
	}
}
