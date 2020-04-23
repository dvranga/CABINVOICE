package com.bridgeLabz.ttdProject;

public class InvocieSummary {
    public double averageFare;
    public double totalFare;
    public int numOfRides;

    public InvocieSummary(int numOfRides, double totalFare) {
        this.numOfRides=numOfRides;
        this.totalFare=totalFare;
        this.averageFare=this.totalFare/this.numOfRides;
    }

    public static void getInvocieSummary(String userId) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvocieSummary)) return false;
        InvocieSummary that = (InvocieSummary) o;
        return Double.compare( that.averageFare, averageFare ) == 0 &&
                Double.compare( that.totalFare, totalFare ) == 0 &&
                numOfRides == that.numOfRides;
    }
}
