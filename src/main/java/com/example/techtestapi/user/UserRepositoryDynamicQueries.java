package com.example.techtestapi.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryDynamicQueries{
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findUserWithQuery(Optional<String> name, Optional<Boolean> active) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        query.select(user);

        if (!name.isEmpty()) {
            query.where(cb.like(user.get("name"), "%" + name.get() + "%"));
        }

        if (!active.isEmpty()) {
           query.where(cb.equal(user.get("active"), active.get()));
        }

        return entityManager.createQuery(query)
                .getResultList();
    }
}
