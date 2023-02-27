package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager posterManager = new PosterManager();
    Poster movie1 = new Poster(1, "A");
    Poster movie2 = new Poster(2, "AB");
    Poster movie3 = new Poster(3, "ABC");
    Poster movie4 = new Poster(4, "ABCD");
    Poster movie5 = new Poster(5, "ABCDE");
    Poster movie6 = new Poster(6, "ABCDEF");
    Poster movie7 = new Poster(7, "ABCDEFG");
    Poster movie8 = new Poster(8, "ABCDEFGH");
    Poster movie9 = new Poster(9, "ABCDEFGHI");
    Poster movie10 = new Poster(10, "ABCDEFGHIJ");
    Poster movie11 = new Poster(11, "ABCDEFGHIJK");
    Poster movie12 = new Poster(12, "ABCDEFGHIJKL");

    @Test
    public void reverseInputIfNoPoster() {
        Poster[] expected = {};
        Poster[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfOnePoster() {
        posterManager.add(movie3);

        Poster[] expected = {movie3};
        Poster[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfFewPoster() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);
        posterManager.add(movie10);
        posterManager.add(movie11);
        posterManager.add(movie12);

        Poster[] expected = {movie12, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfNoPosterWithLimit10() {
        Poster[] expected = {};
        Poster[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfOnePosterWithLimit10() {
        posterManager.add(movie2);

        Poster[] expected = {movie2};
        Poster[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfLessLimitPosterWithLimit10() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);

        Poster[] expected = {movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfEqualPosterWithLimit10() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);
        posterManager.add(movie10);

        Poster[] expected = {movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfOverLimitPosterWithLimit10() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);
        posterManager.add(movie10);
        posterManager.add(movie11);

        Poster[] expected = {movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        Poster[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfLessLimitPosterAndWithLimitAbove10() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);
        posterManager.add(movie10);

        Poster[] expected = {movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = posterManager.findLast(11);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfEqualLimitPosterAndWithLimitAbove10() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);
        posterManager.add(movie10);
        posterManager.add(movie11);

        Poster[] expected = {movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = posterManager.findLast(11);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfOverLimitPosterAndWithLimitAbove10() {
        posterManager.add(movie1);
        posterManager.add(movie2);
        posterManager.add(movie3);
        posterManager.add(movie4);
        posterManager.add(movie5);
        posterManager.add(movie6);
        posterManager.add(movie7);
        posterManager.add(movie8);
        posterManager.add(movie9);
        posterManager.add(movie10);
        posterManager.add(movie11);
        posterManager.add(movie12);
        posterManager.add(movie1);

        Poster[] expected = {movie1, movie12, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3};
        Poster[] actual = posterManager.findLast(11);

        Assertions.assertArrayEquals(expected, actual);
    }
}