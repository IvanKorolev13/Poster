package ru.netology.poster;

public class PosterManager {
    private Poster[] moviePoster = new Poster[0];

    public void add(Poster newPoster) {
        Poster[] tmp = new Poster[moviePoster.length + 1];
        for (int i = 0; i < moviePoster.length; i++) {
            tmp[i] = moviePoster[i];
        }
        tmp[tmp.length - 1] = newPoster;
        moviePoster = tmp;
    }

    public Poster[] findAll() {
        Poster[] result = new Poster[moviePoster.length];
        for (int i = 0; i < moviePoster.length; i++) {
            result[i] = moviePoster[moviePoster.length - 1 - i];
        }
        return result;
    }

    public Poster[] findLast(int limit) {
        int resultLength = limit;
        if (resultLength > moviePoster.length) {
            resultLength = moviePoster.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = moviePoster[moviePoster.length - 1 - i];
        }
        return result;
    }

    public Poster[] findLast() {
        int resultLength = 10;
        if (resultLength > moviePoster.length) {
            resultLength = moviePoster.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = moviePoster[moviePoster.length - 1 - i];
        }
        return result;
    }
}
