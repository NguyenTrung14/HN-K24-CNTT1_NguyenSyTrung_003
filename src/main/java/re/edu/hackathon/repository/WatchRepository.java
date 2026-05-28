package re.edu.hackathon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import re.edu.hackathon.entity.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {
    Page<Watch> findByDeletedFalse(Pageable pageable);

    @Query("""
            select w from Watch w
            where w.deleted = false
              and (
                lower(w.modelName) like lower(concat('%', :keyword, '%'))
                or lower(w.brand) like lower(concat('%', :keyword, '%'))
              )
            """)
    Page<Watch> searchActiveByModelNameOrBrand(@Param("keyword") String keyword, Pageable pageable);
}
