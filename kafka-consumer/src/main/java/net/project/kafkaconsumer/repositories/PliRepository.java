package net.project.kafkaconsumer.repositories;

import net.project.kafkaconsumer.entities.Pli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PliRepository extends JpaRepository<Pli, Long> {
}
