package ru.netology.poster;

public class PosterManager {
    private PosterRepositiry repo;

    public PosterManager(PosterRepositiry repo) {
        this.repo = repo;
    }

    public void add(Poster newPoster) {
        repo.save(newPoster);
    }

    public Poster[] findAll() {
        Poster[] posters = repo.findAll();
        Poster[] result = new Poster[posters.length];
        for (int i = 0; i < posters.length; i++) {
            result[i] = posters[posters.length - 1 - i];
        }
        return result;
    }

    public Poster[] findLast(int limit) {
        Poster[] posters = repo.findAll();
        int resultLength = limit;
        if (resultLength > posters.length) {
            resultLength = posters.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = posters[posters.length - 1 - i];
        }
        return result;
    }

    public Poster[] findLast() {
        Poster[] posters = repo.findAll();
        int resultLength = 10;
        if (resultLength > posters.length) {
            resultLength = posters.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = posters[posters.length - 1 - i];
        }
        return result;
    }
}
