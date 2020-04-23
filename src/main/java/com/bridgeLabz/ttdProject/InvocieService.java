package com.bridgeLabz.ttdProject;

public class InvocieService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PERKILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    private static final double PREMIUM_COST_PERKILOMETER = 15;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double PREMIUM_MINIMUM_FARE = 20;
    public static SERVICETYPE serviceType;
    public RideRepository rideRepository;

    public InvocieService() {
        this.rideRepository=new RideRepository();
    }

    public InvocieService(SERVICETYPE servicetype) {
        this.serviceType=servicetype;
    }


    public double calculatorFare(double distance, int time) {

        double totalFare = distance*MINIMUM_COST_PERKILOMETER+time*COST_PER_TIME;

        return Math.max( totalFare,MINIMUM_FARE );
    }

    public InvocieSummary calculatorFare(Ride[] rides) {
        double totalFare=0;
        for (Ride ride:rides) {
           totalFare+= this.calculatorFare( ride.distance,ride.time );
        }
        return new InvocieSummary( rides.length,totalFare );
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId,rides);
    }


    public InvocieSummary getInvocieSummary(String userId) {
        return this.calculatorFare( rideRepository.getRide(userId) );
    }

    private double premiumCalculatorFare(double distance, int time) {
        double totalFare = distance*PREMIUM_COST_PERKILOMETER+time*PREMIUM_COST_PER_TIME;
        return Math.max( totalFare,PREMIUM_MINIMUM_FARE );
    }

    double totalFare=0;
    public InvocieSummary calculatorFare(SERVICETYPE serviceType, Ride[] rides) {

        if(serviceType.equals( SERVICETYPE.PREMIUM )){
            for (Ride ride:rides) {
                totalFare+=this.premiumCalculatorFare(ride.distance,ride.time);
            }
        }
        else if (serviceType.equals( SERVICETYPE.NORMAL )){
            for (Ride ride : rides) {
                totalFare += this.calculatorFare( ride.distance, ride.time );
            }
        }
        return new InvocieSummary( rides.length, totalFare );
    }
    public enum SERVICETYPE {PREMIUM,NORMAL}
}
