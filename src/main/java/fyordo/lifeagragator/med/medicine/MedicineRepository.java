package fyordo.lifeagragator.med.medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long>, QuerydslPredicateExecutor<Medicine> {
    @Query("select t from Medicine t where t.createdUserId = ?1")
    List<Medicine> findAcessable(Long createdUserId);
}