package fr.neo.revisions.mvc.dao;

import fr.neo.revisions.mvc.model.Partie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartieRepository extends JpaRepository<Partie, Long> {
    // Les méthodes CRUD sont déjà incluses : save, findById, findAll, deleteById, etc.
}
