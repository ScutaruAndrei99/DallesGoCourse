package course5.exercitiul1;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class AuthorRepository {
    private final EntityManager entityManager;

    @Autowired
    public AuthorRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Transactional(readOnly = true)
    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Transactional
    public void save(Author author) {
        entityManager.persist(author);
    }

}
