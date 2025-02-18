package com.zogg.zoggservice.repository;

import com.zogg.zoggservice.entity.CouponCollection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponCollectionRepository extends MongoRepository<CouponCollection, Long> {

    List<CouponCollection> findAllByUserId(Integer userId);

    Optional<CouponCollection> findByVoucherId(String voucherId);
}
