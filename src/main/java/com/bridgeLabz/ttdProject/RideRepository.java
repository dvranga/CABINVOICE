package com.bridgeLabz.ttdProject;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides=null;

    public RideRepository(){
        this.userRides=new HashMap<>(  );
    }

    public void addRide(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get( userId );

        this.userRides.put( userId,new ArrayList<Ride>( Arrays.asList(rides) ) );

    }
    public Ride[] getRide(String userId) {
        return this.userRides.get( userId ).toArray(new Ride[0]);
    }
}
