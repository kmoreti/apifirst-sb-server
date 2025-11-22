package com.moreti.apifirstserver.repositories;

import com.moreti.apifirst.model.Category;
import com.moreti.apifirst.model.Dimensions;
import com.moreti.apifirst.model.Image;
import com.moreti.apifirst.model.Product;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<UUID, Product> productMap = new HashMap<>();

    @Override
    public <S extends Product> S save(S entity) {
        UUID id = UUID.randomUUID();

        Product.ProductBuilder builder = Product.builder();

        if (entity.getCategories() != null && !entity.getCategories().isEmpty()) {
            builder.categories(
                    entity.getCategories().stream()
                            .map(category -> Category.builder()
                                    .id(UUID.randomUUID())
                                    .category(category.getCategory())
                                    .description(category.getDescription())
                                    .dateCreated(OffsetDateTime.now())
                                    .dateUpdated(OffsetDateTime.now())
                                    .build())
                            .collect(Collectors.toList())
            );
        }

        if (entity.getDimensions() != null) {
            builder.dimensions(
                    Dimensions.builder()
                            .length(entity.getDimensions().getLength())
                            .height(entity.getDimensions().getHeight())
                            .width(entity.getDimensions().getWidth())
                            .build()
            );
        }

        if (entity.getImages() != null && !entity.getImages().isEmpty()) {
            builder.images(
                    entity.getImages().stream()
                            .map(image -> Image.builder()
                                    .id(UUID.randomUUID())
                                    .url(image.getUrl())
                                    .altText(image.getAltText())
                                    .dateCreated(OffsetDateTime.now())
                                    .dateUpdated(OffsetDateTime.now())
                                    .build())
                            .collect(Collectors.toList())
            );
        }

        Product product = builder.id(id)
                .price(entity.getPrice())
                .cost(entity.getCost())
                .description(entity.getDescription())
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        productMap.put(id, product);

        return (S) product;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(UUID uuid) {
        return Optional.of(productMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return productMap.get(uuid) != null;
    }

    @Override
    public Iterable<Product> findAll() {
        return productMap.values();
    }

    @Override
    public Iterable<Product> findAllById(Iterable<UUID> uuids) {
        return StreamSupport.stream(uuids.spliterator(),        false)
                .map(this::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return productMap.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        productMap.remove(uuid);
    }

    @Override
    public void delete(Product entity) {
        productMap.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        productMap.clear();
    }

}
