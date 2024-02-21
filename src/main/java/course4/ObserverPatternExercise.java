package course4;
/*
Implementarea unui sistem de notificare cu Observer Pattern

Cerință: Să implementăm un sistem simplu de notificare folosind Observer Pattern, în care un subiect (un post pe o
platformă socială) este observat de mai mulți utilizatori, iar aceștia primesc notificări atunci când sunt făcute
actualizări la post.

 */

import java.util.ArrayList;
import java.util.List;

interface SocialMediaSubject {
    void registerObserver(SocialMediaObserver observer);
    void removeObserver(SocialMediaObserver observer);
    void notifyObservers();
    void publishPost(String content);
}

interface SocialMediaObserver {
    void update(String postContent);
}

class Post implements SocialMediaSubject {
    private String content;
    private List<SocialMediaObserver> observers;

    public Post() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(SocialMediaObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SocialMediaObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (SocialMediaObserver observer : observers) {
            observer.update(content);
        }
    }

    @Override
    public void publishPost(String content) {
        this.content = content;
        notifyObservers();
    }
}

class User implements SocialMediaObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String postContent) {
        System.out.println(name + " a primit o notificare: Un nou post a fost publicat: " + postContent);
    }
}

public class ObserverPatternExercise {
    public static void main(String[] args) {

        Post post = new Post();

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        post.registerObserver(user1);
        post.registerObserver(user2);
        post.registerObserver(user3);

        post.publishPost("Acesta este un post nou pe platforma socială!");

        post.removeObserver(user2);

        post.publishPost("Un alt post nou pe platforma socială!");

        post.removeObserver(user3);

        post.publishPost("Un ultim post nou pe platforma socială!");
    }
}
