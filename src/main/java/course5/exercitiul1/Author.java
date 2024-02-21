package course5.exercitiul1;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

//    public Author orElseThrow(Object o) {
//        Author author=null;
//        return author;
//    }

}
