package edu.iu.camfraiz.historyservice.repository;

import edu.iu.camfraiz.historyservice.model.PrimesRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PrimesHistoryRepository extends CrudRepository<PrimesRecord, Integer> {
    List<PrimesRecord> findAllByCustomer(String customer);
}