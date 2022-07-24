package com.dvp.bayond.repository;

import com.dvp.bayond.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<State, Integer> {
}
