/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.AutorPremio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexa
 */
@Stateless
public class AutorPremioFacade extends AbstractFacade<AutorPremio> {

    @PersistenceContext(unitName = "Biblioteca2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorPremioFacade() {
        super(AutorPremio.class);
    }
    
}
