package com.project.diplom.Dao;

import com.project.diplom.Model.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CameraDaoImpl implements CameraDao {
    private final EntityManager em;

    @Autowired
    public CameraDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Camera loadById(Long id) {
        return em.find(Camera.class, id);
    }

    @Override
    public Camera getCameraByName(String name) {
        CriteriaQuery<Camera> criteria = buildCriteria(name);
        TypedQuery<Camera> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    @Override
    public void saveCamera(Camera camera) {
        em.persist(camera);
    }

    private CriteriaQuery<Camera> buildCriteria(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Camera> criteria = builder.createQuery(Camera.class);
        Root<Camera> camera = criteria.from(Camera.class);
        criteria.select(camera.get("address_ip")).where(builder.equal(camera.get("name"), name));
        return criteria;
    }
}
