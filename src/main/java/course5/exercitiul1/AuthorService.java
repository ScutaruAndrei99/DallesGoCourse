package course5.exercitiul1;
/*
Implementarea relațiilor între entități

Creați două entități Hibernate: Author și Book, care să fie legate printr-o relație de tipul "un autor poate scrie mai
multe cărți". Asigurați-vă că implementați corect această relație în cadrul entităților, folosind adnotările Hibernate
necesare. Adăugați, de asemenea, metode pentru a adăuga o carte unui autor și pentru a obține toate cărțile unui autor.

 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void addBookToAuthor(Long authorId, Book book) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));
        book.setAuthor(author);
        author.getBooks().add(book);
        authorRepository.save(author);
    }
}