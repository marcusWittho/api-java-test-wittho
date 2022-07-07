package org.wittho.repository;

import javax.enterprise.context.ApplicationScoped;

import org.wittho.model.PersonModel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<PersonModel, Long> {
  
}
