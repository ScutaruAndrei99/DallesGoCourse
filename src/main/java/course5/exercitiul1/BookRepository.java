package course5.exercitiul1;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Book> findByAuthorIdAndPublicationDateGreaterThan(Long authorId, LocalDate publicationDate) {
        return entityManager.createQuery(
                        "SELECT b FROM Book b WHERE b.author.id = :authorId AND b.publicationDate > :publicationDate", Book.class)
                .setParameter("authorId", authorId)
                .setParameter("publicationDate", publicationDate)
                .getResultList();
    }
}
