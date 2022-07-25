package com.dvp.bayond.repository;

import com.dvp.bayond.domain.model.StoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreOrderRepository extends JpaRepository<StoreOrder, Integer> {
}
