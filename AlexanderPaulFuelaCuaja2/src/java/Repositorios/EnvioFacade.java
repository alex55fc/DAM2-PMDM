/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Envio;
import Modelos.Proyecto;
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
public class EnvioFacade extends AbstractFacade<Envio> {

    @PersistenceContext(unitName = "AlexanderPaulFuelaCuaja2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnvioFacade() {
        super(Envio.class);
    }
public List<Envio> lista(Proyecto proyectoABuscar) {
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Envio.findByProyecto").setParameter("proyecto", proyectoABuscar);
        return q.getResultList();
}    
}
