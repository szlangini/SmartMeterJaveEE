package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Zaehler implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    String name;
    Float maxAmpere;
    Float currentAmpere;
    Float currentVolt;
    List<Ablesung> ablesungen;
    
    // Constructors:
    public Zaehler(){
        this.id = (long) (100 + (Math.random() * 1000000));
    }
    
    public Zaehler(String name, Float maxAmpere){
        this.name = name;
        this.maxAmpere = maxAmpere;
        this.id = (long) (100 + (Math.random() * 1000000));

    }
    
    public Zaehler(String name,List<Ablesung> ablesungen, Float maxAmpere){
        this.name = name;
        this.ablesungen = ablesungen;
        this.maxAmpere = maxAmpere;
        this.id = (long) (100 + (Math.random() * 1000000));

    }
 
    

	public void setId(Long id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setMaxAmpere(Float maxAmpere) {
		this.maxAmpere = maxAmpere;
	}




	@OneToMany(mappedBy="zaehler")
    public List<Ablesung> getAblesungen() {return this.ablesungen;}
    
    public void setAblesungen(List<Ablesung> ablesungen){ablesungen = this.ablesungen;}
 

    @Column(name="Name")
    public String getName(){return this.name;}

    @Id
	public Long getId(){return this.id;}

	@Column(name="maxAmpere")
    public Float getMaxAmpere() {
		return maxAmpere;
	}

    // Methoden müssen implementiert werden zum erstellen dieser
	public Float getCurrentAmpere() {
		return currentAmpere;
	}

	public void setCurrentAmpere(Float currentAmpere) {
		this.currentAmpere = currentAmpere;
	}

	public Float getCurrentVolt() {
		return currentVolt;
	}

	public void setCurrentVolt(Float currentVolt) {
		this.currentVolt = currentVolt;
	}
	
	// TODO Erstellen von currentVolt und currentAmpere
	
	
    // String Representation:
    @Override
    public String toString() {
        return name + " maxAmpere (" + maxAmpere + ")";
    }
}