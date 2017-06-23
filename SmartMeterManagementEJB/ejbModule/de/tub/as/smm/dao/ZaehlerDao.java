package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Zaehler;

/**
 * Session Bean implementation class ZaehlerDaoEJB
 */
@Stateless
public class ZaehlerDao {

	// Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new Zaehler
    public void persist(Zaehler zaehler) {
        em.persist(zaehler);
    }
 
    // Retrieves all the Zaehler:
    public List<Zaehler> getAllAblesungen() {
        TypedQuery<Zaehler> query = em.createQuery(
            "SELECT z FROM Zaehler z ORDER BY z.id", Zaehler.class);
        return query.getResultList();
    }
    
    // TODO: Query for specific Zaehler

}