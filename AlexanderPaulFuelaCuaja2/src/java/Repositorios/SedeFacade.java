/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Inspectoria;
import Modelos.Responsable;
import Modelos.Sede;
import Modelos.Sederesponsable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alexa
 */
@Stateless
public class SedeFacade extends AbstractFacade<Sede> {

    @PersistenceContext(unitName = "AlexanderPaulFuelaCuaja2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SedeFacade() {
        super(Sede.class);
    }
    //creado para el ejercicio AAejer1_2
    public List sedesResponsablesOrdenados(){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Sede.findAllOrdered");
        return q.getResultList();
    }
    //creado para AAejer1
    public List<Sederesponsable> sedesPorResponsable(Responsable responsableABuscar){
        em = getEntityManager();
        Query q;
        if (responsableABuscar != null)
            q = em.createNamedQuery("Sederesponsable.findByCodResponsable").setParameter("codResponsable", responsableABuscar.getCodResponsable());
        else
            q = em.createNamedQuery("Sederesponsable.findByCodResponsable").setParameter("codResponsable", 3);//por defecto el 3 
        return q.getResultList();
    }
    /*
    //creado para ExamenEjer1
    public List<Sede> SedePorInspectoria(Inspectoria inspect){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Sede.findByInspectoria").setParameter("laInspectoria", inspect);
        return q.getResultList();
    }
*/
    
}
