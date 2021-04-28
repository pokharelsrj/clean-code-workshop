package com.movierental;

class TextStatement {
    public String display(String name, Rentals rentals) {
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.amount()) + "\n";

        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
        result += "You earned " + String.valueOf(rentals.totalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }
}
