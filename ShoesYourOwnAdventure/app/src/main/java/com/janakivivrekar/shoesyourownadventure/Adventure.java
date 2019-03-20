package com.janakivivrekar.shoesyourownadventure;

import java.util.Set;

public class Adventure {
    int radius;
    boolean round_trip;
    Set<AdventureAttribute> attributes;

    public Adventure(int radius, boolean round_trip, Set<AdventureAttribute> attributes) {
        this.radius = radius;
        this.round_trip = round_trip;
        this.attributes = attributes;
    }
}