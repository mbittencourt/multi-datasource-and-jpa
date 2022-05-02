package br.com.test.multidatasource.jpa.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "CustomerMySqlEntity")
@Table(name = "my_table_oracle")
@Data
public class CustomerOracleEntity {

	@Id
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;
	
}
