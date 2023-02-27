package ru.netology.poster;

public class PosterRepositiry {
    private Poster[] moviePoster = new Poster[0];

    //добавление в массив
    public void save(Poster newPoster) {
        Poster[] tmp = new Poster[moviePoster.length + 1];
        for (int i = 0; i < moviePoster.length; i++) {
            tmp[i] = moviePoster[i];
        }
        tmp[tmp.length - 1] = newPoster;
        moviePoster = tmp;
    }

    //возвращение массива
    public Poster[] findAll() {
        Poster[] result = new Poster[moviePoster.length];
        for (int i = 0; i < moviePoster.length; i++) {
            result[i] = moviePoster[i];
        }
        return result;
    }

    //поиск элемента по id, если такого нет, то возвраает null
    public Poster findById(int id) {
        Poster result = null;
        for (Poster movie : moviePoster) {
            if (movie.getId() == id) {
                result = movie;
            }
        }
        return result;
    }

    //удаление элемента по id, если такого нет, то ничего не делает
    public void removeById(int id) {
        Poster[] tmp = new Poster[moviePoster.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < moviePoster.length; i++) {
            if (moviePoster[i].getId() != id) {
                tmp[copyToIndex] = moviePoster[i];
                copyToIndex++;
            }
        }
        if (copyToIndex != moviePoster.length) {
            moviePoster = tmp;
        }
    }

    //удаление всего массива, т.е. его обнуление
    public void removeAll() {
        Poster[] tmp = new Poster[0];
        moviePoster = tmp;
    }

    public Poster[] getMoviePosters() {
        return moviePoster;
    }
}
