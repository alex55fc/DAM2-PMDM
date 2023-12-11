/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

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
public class ResponsableFacade extends AbstractFacade<Responsable> {

    @PersistenceContext(unitName = "AlexanderPaulFuelaCuaja2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsableFacade() {
        super(Responsable.class);
    }
    //hecho para el ejercicio AAejer1
    public List responsablesSedesOrdenados(){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Responsable.findAllOrderedA");
        return q.getResultList();
    }
    //creado para AAejer1_2
public List<Sederesponsable> responsablesPorSedes(Sede sedeABuscar) {
    em = getEntityManager();
    Query q;

    if (sedeABuscar != null) {
        /*IMPORTANTE ESTE CODIGO EN SEDE
        ya que codsede es un string si no hacemos esat linea nos da javaejbexcepcion al mezclar int con strings*/
        String codSede = String.valueOf(sedeABuscar.getCodSede());
        q = em.createNamedQuery("Sederesponsable.findByCodSede").setParameter("codSede", codSede);
    } else {
        String valorPorDefecto = "APADRINAMIENTOS"; // por defecto AUXILIUM PARISH  como String
        q = em.createNamedQuery("Sederesponsable.findByCodSede").setParameter("codSede", valorPorDefecto);
    }

    return q.getResultList();
}

}
