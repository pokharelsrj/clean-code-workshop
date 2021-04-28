package com.movierental;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void noMoviesRented()
    {
        Customer customer = new Customer("Ram");
        assertEquals("Rental Record for Ram\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points",customer.statement());
    }

    @Test
    public void regularMovieRentedForLessThanTwoDays()
    {
        Customer customer = new Customer("Ram");
        customer.addRental(new Rental(new Movie("Interstellar",Movie.REGULAR),1));
        assertEquals("Rental Record for Ram\n" +
                "\tInterstellar\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points",customer.statement());
    }

    @Test
    public void regularMovieRentedForMoreThanTwoDays()
    {
        Customer customer = new Customer("Ram");
        customer.addRental(new Rental(new Movie("Interstellar",Movie.REGULAR),3));
        assertEquals("Rental Record for Ram\n" +
                "\tInterstellar\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points",customer.statement());

    }

    @Test
    public void newReleasesRentedForLessThanOneDay()
    {
        Customer customer = new Customer("Shyam");
        customer.addRental(new Rental(new Movie("Fast and Furious 10",Movie.NEW_RELEASE),1));
        assertEquals("Rental Record for Shyam\n" +
                "\tFast and Furious 10\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points",customer.statement());
    }

    @Test
    public void newReleasesRentedForMoreThanOneDay()
    {
        Customer customer = new Customer("Shyam");
        customer.addRental(new Rental(new Movie("Fast and Furious 10",Movie.NEW_RELEASE),4));
        assertEquals("Rental Record for Shyam\n" +
                "\tFast and Furious 10\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points",customer.statement());
    }

    @Test
    public void childrenMovieRentedForLessThanThreeDays()
    {
        Customer customer = new Customer("Hari");
        customer.addRental(new Rental(new Movie("Frozen",Movie.NEW_RELEASE),1));
        assertEquals("Rental Record for Hari\n" +
                "\tFrozen\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points",customer.statement());
    }

    @Test
    public void childrenMovieRentedForMoreThanThreeDays()
    {
        Customer customer = new Customer("Hari");
        customer.addRental(new Rental(new Movie("Frozen",Movie.NEW_RELEASE),5));
        assertEquals("Rental Record for Hari\n" +
                "\tFrozen\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points",customer.statement());
    }

    @Test
    public void htmlStatementTest()
    {
        Customer customer = new Customer("Hari");
        customer.addRental(new Rental(new Movie("Frozen",Movie.NEW_RELEASE),5));
        assertEquals("<h1>Rental Record for <b>Hari</b></h1><br/>" +
                "Frozen 15.0<br/>" +
                "Amount owed is 15.0<br/>" +
                "You earned <b>2</b> frequent renter points",customer.htmlStatement());
    }

}