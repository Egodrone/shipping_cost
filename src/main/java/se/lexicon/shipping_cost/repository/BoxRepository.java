package se.lexicon.shipping_cost.repository;

import se.lexicon.shipping_cost.entity.Box;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BoxRepository extends CrudRepository<Box, String> {

    List<Box> findAll();
}
