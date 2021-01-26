package com.training.exceptions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Integer>{

	Object findByName(String ordername);

}
