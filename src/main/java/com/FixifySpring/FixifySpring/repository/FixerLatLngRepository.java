package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.FixerLatLng;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface FixerLatLngRepository extends MongoRepository<FixerLatLng, Long> {
    Optional<FixerLatLng> findFixerLatLngByCreator(String creator);
}
