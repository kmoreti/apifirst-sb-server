package com.moreti.apifirstserver.repositories;

import com.moreti.apifirst.model.Order;
import com.moreti.apifirst.model.OrderLine;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final Map<UUID, Order> orderMap = new HashMap<>();

    @Override
    public <S extends Order> S save(S entity) {
        UUID id = UUID.randomUUID();

        Order.OrderBuilder builder = Order.builder().id(id)
                .orderStatus(entity.getOrderStatus())
                .shipmentInfo(entity.getShipmentInfo())
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now());

        if (!entity.getOrderLines().isEmpty()) {
            builder.orderLines(
                    entity.getOrderLines().stream().map(orderLine ->
                                    OrderLine.builder()
                                            .id(UUID.randomUUID())
                                            .product(orderLine.getProduct())
                                            .orderQuantity(orderLine.getOrderQuantity())
                                            .shipQuantity(orderLine.getShipQuantity())
                                            .dateCreated(OffsetDateTime.now())
                                            .dateUpdated(OffsetDateTime.now())
                                            .build()
                            )
                            .collect(Collectors.toList())
            );
        }

        if (entity.getCustomer() != null) {
            builder.customer(entity.getCustomer());
        }

        Order savedOrder = builder.build();

        orderMap.put(id, savedOrder);
        return (S) savedOrder;
    }

    @Override
    public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findById(UUID uuid) {
        return Optional.of(orderMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return orderMap.get(uuid) != null;
    }

    @Override
    public Iterable<Order> findAll() {
        return orderMap.values();
    }

    @Override
    public Iterable<Order> findAllById(Iterable<UUID> uuids) {
        return StreamSupport.stream(uuids.spliterator(), false)
                .map(this::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return orderMap.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        orderMap.remove(uuid);
    }

    @Override
    public void delete(Order entity) {
        orderMap.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        orderMap.clear();
    }
}
