package com.example.petsmart.repository;

import com.example.petsmart.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class PetRepositoryImpl implements PetRepositoryCustom {
    EntityManager entityManager;

    @Override
    public List<Pet> findPets(String petType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pet> cq = cb.createQuery(Pet.class);

        Root<Pet> pet = cq.from(Pet.class);
        List<Predicate> predicates = new ArrayList<>();

        if (petType != null && !petType.isEmpty()) {
            predicates.add(cb.equal(pet.get("petType"), petType));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
