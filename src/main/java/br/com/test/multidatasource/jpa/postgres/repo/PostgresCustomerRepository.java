package br.com.test.multidatasource.jpa.postgres.repo;

import br.com.test.multidatasource.jpa.postgres.entity.CustomerPostgresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresCustomerRepository extends JpaRepository<CustomerPostgresEntity, Integer> {
}
