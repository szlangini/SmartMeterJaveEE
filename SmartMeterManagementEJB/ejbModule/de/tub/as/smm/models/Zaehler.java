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
    // @GeneratedValue
    Long id;
    String name;
    Float maxAmpere;
    Float maxVolt;
    Float currentAmpere;
    Float currentVolt;
    List<Ablesung> ablesungen;
    
    // Constructors:
 
    public Zaehler(String name,List<Ablesung> ablesungen, Float maxAmpere, Float maxVolt){
        this.name = name;
        this.ablesungen = ablesungen;
        this.maxAmpere = maxAmpere;
        this.maxVolt = maxVolt;
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

    @Column(name="maxVolt")
	public Float getMaxVolt() {
		return maxVolt;
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
        return name + "hat folgende Werte: Stromstärke in Ampere (" + currentAmpere + ") Spannung in Volt (" + currentVolt + ")";
    }
}