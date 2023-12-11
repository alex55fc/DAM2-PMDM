/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Tiposorganismos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexa
 */
@Stateless
public class TiposorganismosFacade extends AbstractFacade<Tiposorganismos> {

    @PersistenceContext(unitName = "AlexanderPaulFuelaCuaja2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposorganismosFacade() {
        super(Tiposorganismos.class);
    }
    
}
