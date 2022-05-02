package br.com.test.multidatasource.jpa.oracle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.test.multidatasource.jpa.oracle.entity.CustomerOracleEntity;

@Repository
public interface OracleCustomerRepository extends JpaRepository<CustomerOracleEntity, Integer> {
}
