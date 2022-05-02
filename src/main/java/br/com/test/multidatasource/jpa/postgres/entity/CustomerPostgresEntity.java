package br.com.test.multidatasource.jpa.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "my_table_postgres")
@Data
public class CustomerPostgresEntity {
	
	@Id
	@Column(name = "codigo")
	private String codigo;



}
