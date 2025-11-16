package com.moretii.apifirstserver.repositories;

import com.moreti.apifirst.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private final Map<UUID, Customer> entityMap = new HashMap<>();
    @Override
    public <S extends Customer> S save(S entity) {
        UUID id = UUID.randomUUID();

        Customer customer = Customer.builder()
                .id(id)
                .billToAddress(entity.getBillToAddress())
                .shipToAddress(entity.getShipToAddress())
                .email(entity.getEmail())
                .name(entity.getName())
                .phone(entity.getPhone())
                .dateCreated(entity.getDateCreated())
                .dateUpdated(entity.getDateUpdated())
                .build();
        entityMap.put(id, customer);
        return (S) customer;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findById(UUID uuid) {
        return Optional.of(entityMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return entityMap.get(uuid) != null;
    }

    @Override
    public Iterable<Customer> findAll() {
        return entityMap.values();
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<UUID> uuids) {
        return StreamSupport.stream(uuids.spliterator(), false)
                .map(this::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return entityMap.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        entityMap.remove(uuid);
    }

    @Override
    public void delete(Customer entity) {
        entityMap.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        entityMap.clear();
    }
}
