package course5.exercitiul1;

/*
Utilizarea interogărilor complexe

Scrieți un serviciu Hibernate pentru a efectua o interogare complexă care să returneze toate cărțile scrise de un
anumit autor, ale cărui cărți au fost publicate după o anumită dată. Utilizați criteriile Hibernate pentru a construi
această interogare complexă și asigurați-vă că returnați rezultatele în mod corespunzător.

 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


}
