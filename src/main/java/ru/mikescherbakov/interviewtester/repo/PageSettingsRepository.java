package ru.mikescherbakov.interviewtester.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.mikescherbakov.interviewtester.models.PageSettings;

import java.util.Optional;

public interface PageSettingsRepository extends CrudRepository<PageSettings, Long> {
    @Query(value = "SELECT s FROM PageSettings s WHERE s.name = :name")
    PageSettings findByName(@Param("name") String name);
}
