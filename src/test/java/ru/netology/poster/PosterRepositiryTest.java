package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositiryTest {
    PosterRepositiry repo = Mockito.mock(PosterRepositiry.class);
    PosterManager posterManager = new PosterManager(repo);

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
    public void reverseInputIfLessLimitPosterWithLimit10() {

        Poster[] stub = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
        doReturn(stub).when(repo).findAll();

        Poster[] expected = {movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseInputIfOverLimitPosterAndWithLimitAbove10() {
        Poster[] stub = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12, movie1};
        doReturn(stub).when(repo).findAll();

        Poster[] expected = {movie1, movie12, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3};
        Poster[] actual = posterManager.findLast(11);

        Assertions.assertArrayEquals(expected, actual);
    }
}